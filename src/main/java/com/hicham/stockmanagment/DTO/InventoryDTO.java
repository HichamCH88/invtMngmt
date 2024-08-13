package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Enums.InventoryTransactionType;
import com.hicham.stockmanagment.model.Inventory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryDTO {

    private Integer id;

    private ArticleDTO article;

    private Integer quantity;

    public static InventoryDTO fromEntity(Inventory inv){
        return InventoryDTO.builder().id(inv.getId())
                .article(ArticleDTO.fromEntity(inv.getArticle()))
                .quantity(inv.getQuantity())
                .build();
    }
    public static Inventory toEntity(InventoryDTO dto){
        return Inventory.builder().article(ArticleDTO.toEntity(dto.getArticle()))
                .quantity(dto.getQuantity())
                .build();
    }
}
