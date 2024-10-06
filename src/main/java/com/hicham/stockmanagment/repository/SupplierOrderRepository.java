package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.DTO.SupplierOrderDTO;
import com.hicham.stockmanagment.model.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,Integer> {
    List<SupplierOrder> findBySupplierName(String name);
}
