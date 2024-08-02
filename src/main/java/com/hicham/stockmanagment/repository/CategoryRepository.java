package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryCode(String code);
}
