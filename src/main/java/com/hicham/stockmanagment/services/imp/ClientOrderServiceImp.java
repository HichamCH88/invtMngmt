package com.hicham.stockmanagment.services.imp;
import com.hicham.stockmanagment.DTO.ClientDTO;
import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import com.hicham.stockmanagment.DTO.ClientOrderLineDTO;
import com.hicham.stockmanagment.DTO.InventoryTransactionDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Client;
import com.hicham.stockmanagment.model.ClientOrder;
import com.hicham.stockmanagment.model.Enums.InventoryTransactionType;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import com.hicham.stockmanagment.repository.ArticleRepository;
import com.hicham.stockmanagment.repository.ClientOrderLineRepository;
import com.hicham.stockmanagment.repository.ClientOrderRepository;
import com.hicham.stockmanagment.repository.ClientRepository;
import com.hicham.stockmanagment.services.ClientOrderService;
import com.hicham.stockmanagment.services.InventoryTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

//this service has business logic of clientOrder and ClientOrderLines and transactions
@Service
public class ClientOrderServiceImp implements ClientOrderService {
    private static final Logger log = LoggerFactory.getLogger(ClientOrderServiceImp.class);

    private InventoryTransactionService inventoryTransactionService;
    private ClientRepository clientRepository;
    private ClientOrderRepository clientOrderRepository;
    private ArticleRepository articleRepository;
    private ClientOrderLineRepository clientOrderLineRepository;

    //Injects needed dependencies and repos on the constructor
    @Autowired
    public ClientOrderServiceImp(InventoryTransactionService inventoryTransactionService,
                                 ClientRepository clientRepository,
                                 ClientOrderRepository clientOrderRepository,
                                 ArticleRepository articleRepository,
                                 ClientOrderLineRepository clientOrderLineRepository) {
        this.inventoryTransactionService = inventoryTransactionService;
        this.clientRepository = clientRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.articleRepository = articleRepository;
        this.clientOrderLineRepository = clientOrderLineRepository;
    }




    //Inserting and adding new Client Order to Database
    @Override
    public ClientOrderDTO save(ClientOrderDTO clientOrderDTO) {

    //checks Client order Validation (null or client not found) TODO !! check if OrderCode is unique
        if(clientOrderDTO ==null){
            log.error("client order is null");
            throw new InvalidEntityException("client order is null");
        }
        Optional<Client> client=clientRepository.findById(clientOrderDTO.getClient().getId());
        if(client.isEmpty()){
            log.error("Client does not exist");
            throw new EntityNotFoundException("client not found!",ErrorCode.CLIENTORDER_NOT_Found);
        }

    //finalization and setting Client Order
        clientOrderDTO.setClient(ClientDTO.fromEntity(client.get()));
        clientOrderDTO.setOrderDate(Instant.now());
        clientOrderDTO.setStatus(OrderStatus.onHold);//default value for testing TODO!!remove this line
        ClientOrderDTO savedOrder =ClientOrderDTO.fromEntity(clientOrderRepository.save(ClientOrderDTO.toEntity(clientOrderDTO)));

     //Inserting Client order lines to database
        if(clientOrderDTO.getClientOrderLines()!=null) {
            clientOrderDTO.getClientOrderLines().forEach(CltOrderLn ->{
                if(articleRepository.findById(CltOrderLn.getArticle().getId()).isEmpty())
                {
                    throw new EntityNotFoundException("Article"+CltOrderLn.getArticle().getId()+" doesnt exist");
                }
                    CltOrderLn.setClientOrder(savedOrder);
                    clientOrderLineRepository.save(ClientOrderLineDTO.toEntity(CltOrderLn));
                    //done!!TODO save new transaction (type="clientOrder",quantity="CltOrderLn.getQuantity") and Update inventory quantity!
                    createTransaction(CltOrderLn);
            });
        }
        return savedOrder;
    }

    @Override
    public List<ClientOrderDTO> findAll() {
        return clientOrderRepository.findAll().stream().map(ClientOrderDTO::fromEntity).toList();
    }

    @Override
    public ClientOrderDTO findById(Integer id) {

        if(id==null){
            log.error("id is null");
            throw new EntityNotFoundException("id is null");
        }
        Optional<ClientOrder> co =clientOrderRepository.findById(id);
        if(co.isEmpty()){
            log.warn("Cant find ClientOrder with id"+ id);
            throw new EntityNotFoundException("Cant find Order with this id",ErrorCode.CLIENTORDER_NOT_Found);
        }
        return ClientOrderDTO.fromEntity(co.get());
    }

    @Override
    public ClientOrderDTO findByCode(String code) {

        if(code==null){
            log.error("Id must has a value");
            throw new EntityNotFoundException("id is null");
        }
        Optional<ClientOrder> co =clientOrderRepository.findByCode(code);
        if(co.isEmpty()){
            log.warn("Order does not exist"+ code);
            throw new EntityNotFoundException("Cant find Order with this id",ErrorCode.CLIENTORDER_NOT_Found);
        }
        return ClientOrderDTO.fromEntity(co.get());
    }

    @Override
    public void deleteById(Integer id) {
        if(id==null){
            throw new EntityNotFoundException("Client order dont exist");
        }
        Optional<ClientOrder> order=clientOrderRepository.findById(id);
        if(order.isEmpty()){
            throw new EntityNotFoundException("Client order dont exist");
        }
        order.get().getClientOrderLines().forEach(clientOrderLineRepository::delete);
        clientOrderRepository.deleteById(id);
    }

    @Override
    public List<ClientOrderLineDTO> findByOrderId(Integer clientOrderId) {
        return clientOrderLineRepository.findByClientOrderId(clientOrderId).stream().map(ClientOrderLineDTO::fromEntity).toList();
    }
    public void createTransaction(ClientOrderLineDTO cltOrderLnDto){
        InventoryTransactionDTO invTransDto= InventoryTransactionDTO.builder().transactionDate(Instant.now())
                                                 .transactionSource(cltOrderLnDto.getClientOrder().getClient().getId())
                                                 .article(cltOrderLnDto.getArticle())
                                                 .transactionType(InventoryTransactionType.ClientOrder)
                                                 .quantity(cltOrderLnDto.getQuantity())
                                                 .build();
        System.out.println(invTransDto.getArticle().getId());
        inventoryTransactionService.outTransaction(invTransDto);
    }
}
