package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.CategoryDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {


    @PostMapping(value = "/category/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO save(@RequestBody CategoryDTO categoryDTO);

    @GetMapping(value = "/category/{id}")
    CategoryDTO findCategoryById(@PathVariable("id") int categoryId);

    @GetMapping(value="/categories")
    List<CategoryDTO> findAllCategories();

    @GetMapping(value="/category/c{code}")
    CategoryDTO findCategoryByCode(@PathVariable("code") String categoryCode);

    @PutMapping(value = "/category/updates",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO update(@RequestBody CategoryDTO categoryDTO);

    @DeleteMapping(value = "/category/{id}")
    void deleteCategory(@PathVariable("id")int categoryId);
}
