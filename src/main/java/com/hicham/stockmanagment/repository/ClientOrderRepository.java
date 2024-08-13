package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder,Integer> {

    Optional<ClientOrder> findByCode(String Code);
}
