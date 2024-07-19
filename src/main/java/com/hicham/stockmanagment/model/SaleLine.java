package com.hicham.stockmanagment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="SaleLine")
public class SaleLine extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sale sale;

    @Column(name = "quantity")
    private BigDecimal quantity;
}
