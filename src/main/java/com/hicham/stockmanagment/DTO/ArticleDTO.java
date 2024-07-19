package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDTO {
    private Integer id;

    private String articleCode;

    private String articleDesignation;

    private BigDecimal unitPrice;

    private String pictureUrl;

    private CategoryDTO categoryDTO;
}
