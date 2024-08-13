package com.hicham.stockmanagment.DTO;
import com.hicham.stockmanagment.model.Enums.InventoryTransactionType;
import com.hicham.stockmanagment.model.InventoryTransaction;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class InventoryTransactionDTO {
    private Integer id;

    private Instant transactionDate;

    private InventoryTransactionType transactionType;

    private ArticleDTO article;

    private Integer quantity;

    private Integer transactionSource;


    public static InventoryTransactionDTO fromEntity(InventoryTransaction InvTrans){
        return InventoryTransactionDTO.builder().id(InvTrans.getId())
                .transactionDate(InvTrans.getTransactionDate())
                .article(ArticleDTO.fromEntity(InvTrans.getArticle()))
                .quantity(InvTrans.getQuantity())
                .transactionSource(InvTrans.getTransactionSource())
                .build();
    }

    public static InventoryTransaction toEntity(InventoryTransactionDTO dto){
        System.out.println(dto.getTransactionType());
        return InventoryTransaction.builder().transactionDate(dto.getTransactionDate())
                .article(ArticleDTO.toEntity(dto.getArticle()))
                .quantity(dto.getQuantity())
                .transactionType(dto.getTransactionType())
                .transactionSource(dto.getTransactionSource())
                .build();

    }

}
