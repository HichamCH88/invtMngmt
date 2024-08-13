package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.ClientOrder;
import com.hicham.stockmanagment.model.ClientOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientOrderLineRepository extends JpaRepository<ClientOrderLine,Integer> {
    List<ClientOrderLine> findByClientOrderId(Integer clientOrderId);
}
