package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import com.hicham.stockmanagment.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    Article findByArticleCode(String code );

    List<Article> findByCategoryId(int categoryId);
}
