package com.hicham.stockmanagment.model;


import com.hicham.stockmanagment.model.Enums.InventoryTransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="InventoryTransaction")
public class InventoryTransaction extends AbstractEntity{

    private Instant transactionDate;

    private InventoryTransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "articleID")
    private Article article;

    private Integer quantity;

    private Integer transactionSource;// hold the id of the client/supplier/user depends on transaction type
}
