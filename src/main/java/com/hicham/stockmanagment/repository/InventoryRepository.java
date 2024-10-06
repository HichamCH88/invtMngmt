package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    Inventory findInventoryByArticleId(Integer articleId);
    Inventory findInventoryByArticleArticleCode(String articleCode);
}
