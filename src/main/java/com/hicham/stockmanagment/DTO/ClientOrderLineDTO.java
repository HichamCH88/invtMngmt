package com.hicham.stockmanagment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.ClientOrder;
import com.hicham.stockmanagment.model.ClientOrderLine;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ClientOrderLineDTO {

    private Integer id;

    private ArticleDTO article;

    @JsonIgnore
    private ClientOrderDTO clientOrder;

    private BigDecimal sellingPrice;

    private BigDecimal discount;

    private BigDecimal benefit;

    private Integer quantity;


    public static ClientOrderLineDTO fromEntity(ClientOrderLine clientOrderLine){

        return ClientOrderLineDTO.builder()
                .id(clientOrderLine.getId())
                .article(ArticleDTO.fromEntity(clientOrderLine.getArticle()))
                .clientOrder(ClientOrderDTO.fromEntity(clientOrderLine.getClientOrder()))
                .sellingPrice(clientOrderLine.getSellingPrice())
                .quantity(clientOrderLine.getQuantity())
                .discount(clientOrderLine.getDiscount())
                .benefit(clientOrderLine.getBenefit())
                .build();
    }

    public static ClientOrderLine toEntity(ClientOrderLineDTO clientOrderLineDTO){

        return ClientOrderLine.builder()
                .article(ArticleDTO.toEntity(clientOrderLineDTO.getArticle()))
                .clientOrder(ClientOrderDTO.toEntity(clientOrderLineDTO.getClientOrder()))
                .sellingPrice(clientOrderLineDTO.getSellingPrice())
                .quantity(clientOrderLineDTO.getQuantity())
                .discount(clientOrderLineDTO.getDiscount())
                .Benefit(clientOrderLineDTO.getBenefit())
                .build();

    }
}
