package com.hicham.stockmanagment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import com.hicham.stockmanagment.model.Supplier;
import com.hicham.stockmanagment.model.SupplierOrder;
import com.hicham.stockmanagment.model.SupplierOrderLine;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class SupplierOrderDTO {

    private Integer id;

    private String code;

    private Instant orderDate;

    private SupplierDTO supplier;

    private OrderStatus orderStatus;

    private List<SupplierOrderLineDTO> supplierOrderLines;

    public static SupplierOrderDTO fromEntity(SupplierOrder supplierOrder){
        return SupplierOrderDTO.builder().id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .orderDate(supplierOrder.getOrderDate())
                .orderStatus(supplierOrder.getOrderStatus())
                .supplier(SupplierDTO.fromEntity(supplierOrder.getSupplier()))
                .build();
    }
    public static SupplierOrder toEntity(SupplierOrderDTO dto){
        SupplierOrder supplierOrder= SupplierOrder.builder().code(dto.getCode())
                .OrderDate(dto.getOrderDate())
                .orderStatus(dto.getOrderStatus())
                .supplier(SupplierDTO.toEntity(dto.getSupplier()))
                .build();
        supplierOrder.setId(dto.getId());
        return supplierOrder;
    }
}
