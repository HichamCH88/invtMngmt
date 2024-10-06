package com.hicham.stockmanagment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Supplier")
public class Supplier extends AbstractEntity{

    @Column(name = "Name")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNum;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders;

}
