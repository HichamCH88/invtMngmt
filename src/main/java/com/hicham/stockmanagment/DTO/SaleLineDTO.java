package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Sale;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class SaleLineDTO {


    private Integer id;
    private SaleDTO sale;

    @Column(name = "quantity")
    private BigDecimal quantity;
}
