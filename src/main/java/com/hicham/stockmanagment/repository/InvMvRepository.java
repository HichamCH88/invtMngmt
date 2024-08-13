package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvMvRepository extends JpaRepository<InventoryTransaction,Integer> {
}
