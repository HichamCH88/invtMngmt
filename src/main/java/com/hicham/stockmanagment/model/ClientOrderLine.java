package com.hicham.stockmanagment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="ClientOrderLine")
public class ClientOrderLine extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="articleId")
    private Article article;

    @ManyToOne
    @JoinColumn(name="clientOrderId")
    private ClientOrder clientOrder;


}
