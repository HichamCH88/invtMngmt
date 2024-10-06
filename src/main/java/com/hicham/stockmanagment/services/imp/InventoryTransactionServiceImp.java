package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.InventoryTransactionDTO;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Inventory;
import com.hicham.stockmanagment.model.InventoryTransaction;
import com.hicham.stockmanagment.repository.InvMvRepository;
import com.hicham.stockmanagment.repository.InventoryRepository;
import com.hicham.stockmanagment.services.InventoryTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InventoryTransactionServiceImp implements InventoryTransactionService {


    private static final Logger log = LoggerFactory.getLogger(InventoryTransactionServiceImp.class);

    private InvMvRepository invMvRepository;
    private InventoryRepository inventoryRepository;

    public InventoryTransactionServiceImp(InvMvRepository invMvRepository, InventoryRepository inventoryRepository) {
        this.invMvRepository = invMvRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public BigDecimal getArticleRealQte(Integer articleId) {
        return null;
    }

    @Override
    public List<InventoryTransaction> getArticleTransactions(Integer articleId) {
        return List.of();
    }

    @Override
    public InventoryTransactionDTO create(InventoryTransactionDTO dto) {

        return InventoryTransactionDTO
                .fromEntity(
                        this.invMvRepository.save(InventoryTransactionDTO.toEntity(dto))
                );
    }

    @Override
    public InventoryTransactionDTO inTransaction(InventoryTransactionDTO dto) {
        if(dto==null){
            log.error("Invalid transaction");
            throw new InvalidEntityException("Invalid transaction");
        }
        System.out.println(dto.getArticle().getArticleCode());
        updateInventoryQTY(dto.getArticle().getArticleCode(),dto.getQuantity());
        return InventoryTransactionDTO.fromEntity(invMvRepository.save(InventoryTransactionDTO.toEntity(dto)));
    }

    //outTransaction is called when we sell an article (clientOrders or normal Sales)
    @Override
    public InventoryTransactionDTO outTransaction(InventoryTransactionDTO dto) {
        if(dto==null){
            log.error("Invalid transaction");
            throw new InvalidEntityException("Invalid transaction");
        }
        updateInventoryQTY(dto.getArticle().getArticleCode(),-dto.getQuantity());
        return InventoryTransactionDTO.fromEntity(invMvRepository.save(InventoryTransactionDTO.toEntity(dto)));
    }

    @Override
    public InventoryTransactionDTO modifyTrans(InventoryTransactionDTO dto) {
        return null;
    }

    private void updateInventoryQTY(String articleCode,Integer transQTY){
            Inventory inventoryRaw =inventoryRepository.findInventoryByArticleArticleCode(articleCode);

            inventoryRaw.setQuantity(inventoryRaw.getQuantity()+transQTY);
            inventoryRaw.setArticle(inventoryRaw.getArticle());
            inventoryRepository.save(inventoryRaw);


    }
}
