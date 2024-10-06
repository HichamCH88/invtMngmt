package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.*;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.Enums.InventoryTransactionType;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import com.hicham.stockmanagment.model.SupplierOrder;
import com.hicham.stockmanagment.repository.ArticleRepository;
import com.hicham.stockmanagment.repository.SupplierOrderLineRepository;
import com.hicham.stockmanagment.repository.SupplierOrderRepository;
import com.hicham.stockmanagment.repository.SupplierRepository;
import com.hicham.stockmanagment.services.ArticleService;
import com.hicham.stockmanagment.services.InventoryTransactionService;
import com.hicham.stockmanagment.services.SupplierOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierOrderServiceImp implements SupplierOrderService {
    private static final Logger log = LoggerFactory.getLogger(SupplierOrderServiceImp.class);

    private SupplierRepository supplierRepository;
    private SupplierOrderRepository supplierOrderRepository;
    private SupplierOrderLineRepository supplierOrderLineRepository;
    private ArticleService articleService;
    private InventoryTransactionService inventoryTransactionService;
    @Autowired
    public SupplierOrderServiceImp(SupplierRepository supplierRepository,
                                   SupplierOrderRepository supplierOrderRepository,
                                   SupplierOrderLineRepository supplierOrderLineRepository,
                                   ArticleService articleService,
                                   InventoryTransactionService inventoryTransactionService) {
        this.supplierRepository = supplierRepository;
        this.supplierOrderRepository = supplierOrderRepository;
        this.supplierOrderLineRepository = supplierOrderLineRepository;
        this.articleService = articleService;
        this.inventoryTransactionService = inventoryTransactionService;
    }

    @Override
    public SupplierOrderDTO save(SupplierOrderDTO dto) {
        if(dto==null){
            log.error("supplier order dto is null");
            throw new InvalidEntityException("order cant be null:");
        }
        if(dto.getSupplier().getId()==null||!supplierRepository.existsById(dto.getSupplier().getId()))
        {
            throw new EntityNotFoundException("supplier does not exist");
        }

        dto.setOrderDate(Instant.now());
        dto.setOrderStatus(OrderStatus.Recived);
        if(dto.getSupplierOrderLines()==null){
            throw new InvalidEntityException("can't create an order without order lines");
        }
        SupplierOrder savedOrder =supplierOrderRepository.save(SupplierOrderDTO.toEntity(dto));

        dto.getSupplierOrderLines().forEach(solDto->{//TODO: check orderLine validation
            System.out.println("im here"+solDto.getArticle().getArticleCode());
            ArticleDTO isFound =articleService.findByCodeArticle(solDto.getArticle().getArticleCode());
            System.out.println(isFound);
            if(isFound==null)//todo: find by article code
            {
                //save the created article into our order line(because a new id is auto generated)
                solDto.setArticle(articleService.save(solDto.getArticle()));
                log.warn("added new article" + solDto.getArticle().getArticleDesignation());
                System.out.println("Not found");
                isFound=solDto.getArticle();
            }
            this.articleService.updatePrice(solDto.getArticle());
            solDto.setArticle(isFound);
            solDto.setSupplierOrder(SupplierOrderDTO.fromEntity(savedOrder));
            supplierOrderLineRepository.save(SupplierOrderLineDTO.toEntity(solDto));
            createTransaction(solDto);
        });
        return SupplierOrderDTO.fromEntity(savedOrder);
    }

    @Override
    public List<SupplierOrderDTO> findAll() {
        return supplierOrderRepository.findAll().stream().map(SupplierOrderDTO::fromEntity).toList();
    }

    @Override
    public SupplierOrderDTO findById(Integer id) {
        if(id==null){
            throw new InvalidEntityException("Id is null");
        }
        Optional<SupplierOrder> supplierOrder=supplierOrderRepository.findById(id);
        if(supplierOrder.isEmpty()){
            throw new EntityNotFoundException("Can't find order with this id");
        }
        return SupplierOrderDTO.fromEntity(supplierOrder.get());
    }

    @Override
    public void deleteById(Integer id) {
        if(id==null){
            throw new InvalidEntityException("id is null");
        }
        Optional<SupplierOrder> supplierOrder=supplierOrderRepository.findById(id);
        if(supplierOrder.isEmpty()){
            throw new EntityNotFoundException("Can't find order with this id");
        }
        supplierOrderRepository.deleteById(id);
    }

    @Override
    public List<SupplierOrderLineDTO> getOrderLines(Integer id) {
        return supplierOrderLineRepository.findBySupplierOrderId(id).stream().map(SupplierOrderLineDTO::fromEntity).toList();
    }

    @Override
    public List<SupplierOrderDTO> getBySupplierName(String name) {
        return this.supplierOrderRepository.findBySupplierName(name).stream().map(SupplierOrderDTO::fromEntity).toList();
    }


    public void createTransaction(SupplierOrderLineDTO solDTO){
        InventoryTransactionDTO invTransDto= InventoryTransactionDTO.builder().transactionDate(Instant.now())
                .transactionSource(solDTO.getSupplierOrder().getSupplier().getId())
                .article(solDTO.getArticle())
                .transactionType(InventoryTransactionType.SupplierOrder)
                .quantity(solDTO.getQuantity())
                .build();

                System.out.println(solDTO.getQuantity());
        inventoryTransactionService.inTransaction(invTransDto);
    }
}
