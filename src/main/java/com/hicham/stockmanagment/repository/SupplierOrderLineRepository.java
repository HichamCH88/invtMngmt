package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine,Integer> {
}
