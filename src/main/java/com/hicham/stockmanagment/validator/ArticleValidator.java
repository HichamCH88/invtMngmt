package com.hicham.stockmanagment.validator;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDTO articleDTO){
        List<String> errors =new ArrayList<>();
        if(articleDTO==null){
            errors.add("Please insert the Article Code");
            errors.add("Please insert the Article designation");
            errors.add("Please insert the Article price");
        }
        if(articleDTO==null|| !StringUtils.hasLength(articleDTO.getArticleCode())){
            errors.add("Please insert the Article Code");
        }
        if(articleDTO==null||!StringUtils.hasLength(articleDTO.getArticleDesignation())){
            errors.add("Please insert the Article designation");
        }
        if(articleDTO==null||articleDTO.getBuyPrice()==null|| articleDTO.getBuyPrice().intValue()<0){
            errors.add("unite price is invalid");
        }
        return errors;

    }
}
