package com.hicham.stockmanagment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="SupplierOrder")
public class SupplierOrder extends AbstractEntity{

    @Column(name="code")
    private String code;

    @Column(name="OrderDate")
    private Instant OrderDate;

    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplierOrder")
    private List<SupplierOrderLine> supplierOrderLines;
}
