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

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


}
