package com.hicham.stockmanagment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
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
