package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
