package com.hicham.stockmanagment.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Article")
public class Article extends AbstractEntity{
    @Column(name="Code")
    private String articleCode;

    @Column(name="Designation")
    private String articleDesignation;

    @Column(name="unitePrice")
    private BigDecimal unitPrice;

    @Column(name="pictureUrl")
    private String pictureUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "article")
    private List<InventoryTransaction> inventoryTransactions;

}
