package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.SaleLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleLineRepository extends JpaRepository<SaleLine,Integer> {
}
