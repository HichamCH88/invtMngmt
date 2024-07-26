package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepository extends JpaRepository<ClientOrder,Integer> {
}
