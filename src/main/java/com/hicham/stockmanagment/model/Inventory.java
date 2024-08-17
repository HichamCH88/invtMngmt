package com.hicham.stockmanagment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Inventory")//!!if scale to multi-inventories this table become"InventoryElement" and we create new table inventory with inventory id and name and location!
public class Inventory extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articleId")
    private Article article;

    @Column(name = "quantity")
    private Integer quantity=0;
}
