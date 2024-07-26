package com.hicham.stockmanagment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategoryDTO {

    private Integer id;

    private String categoryCode;

    private String CategoryDesignation;
    @JsonIgnore
    private List<ArticleDTO> articles;

    // CATEGORY TO CATEGORYDTO
    public CategoryDTO fromEntity(Category category){
        if(category==null){
            return null;
            //TODO throw an exception
        }
        return CategoryDTO.builder()
                .id(category.getId())
                .categoryCode(category.getCategoryCode())
                .CategoryDesignation(category.getCategoryDesignation())
                .build();
    }

    public Category toEntity(CategoryDTO categoryDTO){
        if (categoryDTO==null){
            return null;
        }
        return Category.builder()
                .categoryCode(categoryDTO.getCategoryCode())
                .CategoryDesignation(categoryDTO.getCategoryDesignation())
                .build();
    }
}
  

