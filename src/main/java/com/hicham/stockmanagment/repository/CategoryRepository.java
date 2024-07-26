package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
