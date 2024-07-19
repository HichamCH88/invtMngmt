package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.SaleLine;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SaleDTO {


    private Integer id;
    private String code;


    private List<SaleLineDTO> saleLines;
}
