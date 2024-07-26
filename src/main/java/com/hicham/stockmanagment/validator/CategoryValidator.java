package com.hicham.stockmanagment.validator;

import com.hicham.stockmanagment.DTO.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDTO categoryDTO){
        List<String> errors =new ArrayList<>();

        if ( categoryDTO==null||!StringUtils.hasLength(categoryDTO.getCategoryCode())){
            errors.add("Category code must be inserted");
        }
        return errors;
    }
}
