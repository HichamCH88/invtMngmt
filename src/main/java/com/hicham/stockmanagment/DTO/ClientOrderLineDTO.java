package com.hicham.stockmanagment.DTO;

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

    private ClientOrderDTO clientOrder;

    private BigDecimal unitePrice;

    private Integer quantity;


    public static ClientOrderLineDTO fromEntity(ClientOrderLine clientOrderLine){

        return ClientOrderLineDTO.builder()
                .id(clientOrderLine.getId())
                .article(ArticleDTO.fromEntity(clientOrderLine.getArticle()))
                .clientOrder(ClientOrderDTO.fromEntity(clientOrderLine.getClientOrder()))
                .unitePrice(clientOrderLine.getUnitePrice())
                .quantity(clientOrderLine.getQuantity())
                .build();
    }

    public static ClientOrderLine toEntity(ClientOrderLineDTO clientOrderLineDTO){

        return ClientOrderLine.builder()
                .article(ArticleDTO.toEntity(clientOrderLineDTO.getArticle()))
                .clientOrder(ClientOrderDTO.toEntity(clientOrderLineDTO.getClientOrder()))
                .unitePrice(clientOrderLineDTO.getUnitePrice())
                .quantity(clientOrderLineDTO.getQuantity())
                .build();

    }
}
