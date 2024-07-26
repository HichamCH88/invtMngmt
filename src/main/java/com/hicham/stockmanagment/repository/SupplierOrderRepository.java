package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,Integer> {
}
