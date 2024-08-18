package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine,Integer> {
    List<SupplierOrderLine> findBySupplierOrderId(Integer id);
}
