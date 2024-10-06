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
@Table(name="ClientOrderLine")
public class ClientOrderLine extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="articleId")
    private Article article;

    @ManyToOne
    @JoinColumn(name="clientOrderId")
    private ClientOrder clientOrder;

    @Column(name="sellingPrice")
    private BigDecimal sellingPrice;

    @Column(name="Discount")
    private BigDecimal discount;

    @Column(name="Benefit")
    private BigDecimal Benefit;

    @Column(name="quantity")
    private Integer quantity;

}
