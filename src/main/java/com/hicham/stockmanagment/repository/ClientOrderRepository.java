package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.ClientOrder;
import com.hicham.stockmanagment.model.Enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder,Integer> {

    Optional<ClientOrder> findByCode(String Code);
    List<ClientOrder> findByClientId(Integer id);
    List<ClientOrder> findByStatus(OrderStatus status);
}
