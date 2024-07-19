package com.hicham.stockmanagment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="ClientOrder")
public class ClientOrder extends AbstractEntity{

    @Column(name="code")
    private String code;

    @Column(name="orderDate")
    private Instant orderDate;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "clientOrder")
    private List<ClientOrderLine> clientOrderLines;
}
