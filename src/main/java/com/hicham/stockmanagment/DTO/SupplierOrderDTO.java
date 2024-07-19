package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Supplier;
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

    private Instant OrderDate;

    private SupplierDTO supplier;

    private List<SupplierOrderLineDTO> supplierOrderLines;
}
