package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    Article findByArticleCode(String code );
}
