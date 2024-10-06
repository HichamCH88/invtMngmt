package com.hicham.stockmanagment.model;


import com.hicham.stockmanagment.model.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="ClientOrder")
public class ClientOrder extends AbstractEntity{

    @Column(name="code")
    private String code;

    @Column(name="orderDate")
    private Instant orderDate;

    @Column(name="Status")
    private OrderStatus status=OrderStatus.onHold;

    @Column(name="Total")
    private BigDecimal total;

    @Column(name="DiscountOnItems")
    private BigDecimal discountOnItems;

    @Column(name="Discount")
    private BigDecimal discount;

    @Column(name="Benefit")
    private BigDecimal benefit;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "clientOrder")
    private List<ClientOrderLine> clientOrderLines;
}
