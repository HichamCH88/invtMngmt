package com.hicham.stockmanagment.controller;

import com.hicham.stockmanagment.DTO.CategoryDTO;
import com.hicham.stockmanagment.controller.api.CategoryApi;
import com.hicham.stockmanagment.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    CategoryService categoryService ;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        System.out.println(categoryDTO.getCategoryCode());
        return categoryService.save(categoryDTO);
    }

    @Override
    public CategoryDTO findCategoryById(int categoryId) {
        return  categoryService.findById(categoryId);
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        return categoryService.findAll();
    }

    @Override
    public CategoryDTO findCategoryByCode(String categoryCode) {
        return categoryService.findByCode(categoryCode);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryService.delete(categoryId);
    }
}
