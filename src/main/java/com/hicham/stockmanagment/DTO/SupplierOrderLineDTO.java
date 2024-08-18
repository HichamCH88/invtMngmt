package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.SupplierOrder;
import com.hicham.stockmanagment.model.SupplierOrderLine;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SupplierOrderLineDTO {

    private Integer id;

    private ArticleDTO article;

    private SupplierOrderDTO supplierOrder;

    private Integer quantity;

    private BigDecimal buyingPrice;

    public static SupplierOrderLineDTO fromEntity(SupplierOrderLine supplierOrderLine){
        return SupplierOrderLineDTO.builder().id(supplierOrderLine.getId())
                .article(ArticleDTO.fromEntity(supplierOrderLine.getArticle()))
                .supplierOrder(SupplierOrderDTO.fromEntity(supplierOrderLine.getSupplierOrder()))
                .quantity(supplierOrderLine.getQuantity())
                .buyingPrice(supplierOrderLine.getBuyingPrice())
                .build();
    }
    public static SupplierOrderLine toEntity(SupplierOrderLineDTO dto){
       SupplierOrderLine soline= SupplierOrderLine.builder().article(ArticleDTO.toEntity(dto.getArticle()))
                .supplierOrder(SupplierOrderDTO.toEntity(dto.getSupplierOrder()))
                .quantity(dto.getQuantity())
                .buyingPrice(dto.getBuyingPrice())
                .build();
       soline.setId(dto.getId());
       return soline;
    }
}
