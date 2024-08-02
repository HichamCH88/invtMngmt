package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO);

    CategoryDTO findById(Integer id);

    CategoryDTO findByCode(String code);

    List<CategoryDTO> findAll();

    void delete(Integer id);

}
