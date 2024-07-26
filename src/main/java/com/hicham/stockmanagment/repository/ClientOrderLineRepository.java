package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.ClientOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderLineRepository extends JpaRepository<ClientOrderLine,Integer> {
}
