package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryCode(String code);
}
