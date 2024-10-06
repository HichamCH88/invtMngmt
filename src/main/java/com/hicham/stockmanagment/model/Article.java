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

    @Column(name="buyPrice")
    private BigDecimal buyPrice;

    @Column(name="detailPrice")
    private BigDecimal detailPrice=BigDecimal.valueOf(0.0);

    @Column(name="pictureUrl")
    private String pictureUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToOne(mappedBy = "article",cascade = CascadeType.ALL)
    private Inventory inventory;

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private List<InventoryTransaction> inventoryTransactions;

    @OneToMany(mappedBy = "article")
    private List<ClientOrderLine> clientOrderLines;

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private List<SupplierOrderLine> supplierOrderLines;

    @OneToMany(mappedBy = "article")
    private List<SaleLine> saleLines;

}
