package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDTO {
    private Integer id;

    private String articleCode;

    private String articleDesignation;

    private BigDecimal buyPrice;

    private BigDecimal detailPrice;

    private String pictureUrl;

    private CategoryDTO categoryDTO;

    public static ArticleDTO fromEntity(Article article){
        if(article==null){
            return null;
        }
        return ArticleDTO.builder()
                .id(article.getId())
                .articleCode(article.getArticleCode())
                .articleDesignation(article.getArticleDesignation())
                .buyPrice(article.getBuyPrice())
                .detailPrice(article.getDetailPrice())
                .pictureUrl(article.getPictureUrl())
                .categoryDTO(CategoryDTO.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDTO articleDTO){

        Article article= Article.builder()
                .articleCode(articleDTO.getArticleCode())
                .articleDesignation(articleDTO.getArticleDesignation())
                .buyPrice(articleDTO.getBuyPrice())
                .detailPrice(articleDTO.getDetailPrice())
                .pictureUrl(articleDTO.getPictureUrl())
                .category(CategoryDTO.toEntity(articleDTO.getCategoryDTO()))
                .build();
        article.setId(articleDTO.getId());
        return article;

    }
}
