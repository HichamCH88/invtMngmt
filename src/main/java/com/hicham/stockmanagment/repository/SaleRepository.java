package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
