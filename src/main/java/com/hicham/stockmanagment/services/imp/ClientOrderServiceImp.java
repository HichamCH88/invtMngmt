package com.hicham.stockmanagment.services.imp;
import com.hicham.stockmanagment.DTO.ClientOrderDTO;
import com.hicham.stockmanagment.DTO.ClientOrderLineDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.ClientOrder;
import com.hicham.stockmanagment.repository.ArticleRepository;
import com.hicham.stockmanagment.repository.ClientOrderLineRepository;
import com.hicham.stockmanagment.repository.ClientOrderRepository;
import com.hicham.stockmanagment.repository.ClientRepository;
import com.hicham.stockmanagment.services.ClientOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClientOrderServiceImp implements ClientOrderService {
    private static final Logger log = LoggerFactory.getLogger(ClientOrderServiceImp.class);

    private ClientRepository clientRepository;
    private ClientOrderRepository clientOrderRepository;
    private ArticleRepository articleRepository;
    private ClientOrderLineRepository clientOrderLineRepository;

    @Autowired
    public ClientOrderServiceImp(ClientRepository clientRepository, ClientOrderRepository clientOrderRepository, ArticleRepository articleRepository, ClientOrderLineRepository clientOrderLineRepository) {
        this.clientRepository = clientRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.articleRepository = articleRepository;
        this.clientOrderLineRepository = clientOrderLineRepository;
    }

    @Override
    public ClientOrderDTO save(ClientOrderDTO clientOrderDTO) {
        if(clientOrderDTO ==null){
            log.error("client order is null");
            throw new InvalidEntityException("clientorder is null");
        }
        if(clientRepository.findById(clientOrderDTO.getClient().getId()).isEmpty()){
            log.error("Client doesnt excist");
            throw new EntityNotFoundException("client not found!",ErrorCode.CLIENTORDER_NOT_Found);
        }

        ClientOrderDTO savedcmd =ClientOrderDTO.fromEntity(clientOrderRepository.save(ClientOrderDTO.toEntity(clientOrderDTO)));

        clientOrderDTO.getClientOrderLines().forEach(codl ->
              clientOrderLineRepository.save(ClientOrderLineDTO.toEntity(codl)));

        return savedcmd;
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
            log.error("id is null");
            throw new EntityNotFoundException("id is null");
        }
        Optional<ClientOrder> co =clientOrderRepository.findByCode(code);
        if(co.isEmpty()){
            log.warn("Cant find ClientOrder with id"+ code);
            throw new EntityNotFoundException("Cant find Order with this id",ErrorCode.CLIENTORDER_NOT_Found);
        }
        return ClientOrderDTO.fromEntity(co.get());
    }

    @Override
    public void deleteById(Integer id) {
        clientOrderRepository.findById(id).get().getClientOrderLines().forEach(clientOrderLineRepository::delete);
        clientOrderRepository.deleteById(id);

    }
}
