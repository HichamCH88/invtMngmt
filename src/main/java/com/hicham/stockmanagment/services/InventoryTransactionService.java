package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.InventoryTransactionDTO;
import com.hicham.stockmanagment.model.InventoryTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface InventoryTransactionService {

    BigDecimal getArticleRealQte(Integer articleId);

    List<InventoryTransaction> getArticleTransactions(Integer articleId);

    InventoryTransactionDTO create(InventoryTransactionDTO dto);

    InventoryTransactionDTO inTrans(InventoryTransactionDTO dto);

    InventoryTransactionDTO outTransaction(InventoryTransactionDTO dto);

    InventoryTransactionDTO modifyTrans(InventoryTransactionDTO dto);

}
