package com.hicham.stockmanagment.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="SupplierOrderLine")
public class SupplierOrderLine extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="articleId")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="supplierOrderId")
    private SupplierOrder supplierOrder;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name ="buyingPrice")
    private BigDecimal buyingPrice=BigDecimal.valueOf(0.0);

}
