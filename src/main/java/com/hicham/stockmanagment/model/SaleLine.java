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
@Table(name="SaleLine")
public class SaleLine extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="articleId")
    private Article article;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name="sellingPrice")
    private BigDecimal sellingPrice;

}
