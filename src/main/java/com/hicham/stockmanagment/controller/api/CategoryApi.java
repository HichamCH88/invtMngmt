package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.CategoryDTO;
import com.hicham.stockmanagment.Shared.Consts;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {


    @PostMapping(value = Consts.APP_ROOT+"/category/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO save(@RequestBody CategoryDTO categoryDTO);

    @GetMapping(value = Consts.APP_ROOT+"/category/{id}")
    CategoryDTO findCategoryById(@PathVariable("id") int categoryId);

    @GetMapping(value=Consts.APP_ROOT+"/category/all")
    List<CategoryDTO> findAllCategories();

    @GetMapping(value=Consts.APP_ROOT+"/category/c{code}")
    CategoryDTO findCategoryByCode(@PathVariable("code") String categoryCode);

    @PutMapping(value =Consts.APP_ROOT+ "/category/updates",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO update(@RequestBody CategoryDTO categoryDTO);

    @DeleteMapping(value =Consts.APP_ROOT+ "/category/{id}")
    void deleteCategory(@PathVariable("id")int categoryId);
}
