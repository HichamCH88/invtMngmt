package com.hicham.stockmanagment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Supplier")
public class Supplier extends AbstractEntity{

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Embedded
    private address address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumbre")
    private String phoneNum;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders;

}
