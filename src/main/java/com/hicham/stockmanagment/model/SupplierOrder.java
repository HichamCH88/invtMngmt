package com.hicham.stockmanagment.model;

import com.hicham.stockmanagment.model.Enums.OrderStatus;
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

    @Column(name="orderStatus")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplierOrder",cascade = CascadeType.ALL)
    private List<SupplierOrderLine> supplierOrderLines;
}
