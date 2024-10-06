package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import com.hicham.stockmanagment.DTO.InventoryDTO;
import com.hicham.stockmanagment.DTO.InventoryTransactionDTO;
import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.Enums.InventoryTransactionType;
import com.hicham.stockmanagment.model.Inventory;
import com.hicham.stockmanagment.model.InventoryTransaction;
import com.hicham.stockmanagment.repository.ArticleRepository;
import com.hicham.stockmanagment.repository.InventoryRepository;
import com.hicham.stockmanagment.services.InventoryService;
import com.hicham.stockmanagment.services.InventoryTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.time.Instant;
import java.util.List;

@Service
public class InventoryServiceImp implements InventoryService {

    private InventoryRepository inventoryRepository;
    private InventoryTransactionService inventoryTransactionService;
    private ArticleRepository articleRepository;

    @Autowired
    public InventoryServiceImp(InventoryRepository inventoryRepository,
                               InventoryTransactionService inventoryTransactionService,
                               ArticleRepository articleRepository) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryTransactionService=inventoryTransactionService;
        this.articleRepository=articleRepository;
    }

    @Override
    public InventoryDTO update(InventoryDTO dto) {

        //create a new inventoryRaw then check if article exist in the inventory
        //if it doesnt then we save the article from dto to our article repo
        //then (in both cases)  we save the new inventory raw to inventory repo
        Inventory invRaw = this.inventoryRepository.findInventoryByArticleArticleCode(
                dto.getArticle().getArticleCode()
        );
        if(invRaw==null){
            Article article=this.articleRepository.save(ArticleDTO.toEntity(dto.getArticle()));
            invRaw=Inventory.builder().article(article)
                    .quantity(0)
                    .build();
        }
        Integer oldQTY=invRaw.getQuantity();
        invRaw.setQuantity(dto.getQuantity());

        InventoryDTO savedInvRaw =InventoryDTO.fromEntity(inventoryRepository.save(invRaw));

        InventoryTransactionDTO inventoryTransactionDTO=InventoryTransactionDTO.builder()
                .transactionDate(Instant.now())
                .transactionSource(1)
                .transactionType(InventoryTransactionType.Modified)
                .quantity(dto.getQuantity()-oldQTY)
                .article(ArticleDTO.fromEntity((this.articleRepository.findByArticleCode(dto.getArticle().getArticleCode()))))
                .build();
        System.out.println(inventoryTransactionDTO.getArticle().getArticleDesignation());
        this.inventoryTransactionService.create(inventoryTransactionDTO);
        return  savedInvRaw;
    }

    @Override
    public List<InventoryDTO> findAll() {
        return this.inventoryRepository.findAll().stream().map(InventoryDTO::fromEntity).toList();
    }

    @Override
    public InventoryDTO findByArticle(Integer id) {
        return InventoryDTO.fromEntity(this.inventoryRepository.findInventoryByArticleId(id));
    }
}
