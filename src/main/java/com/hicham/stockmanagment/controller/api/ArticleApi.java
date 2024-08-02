package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

public interface ArticleApi {

    @PostMapping(value = "sm/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO save(@RequestBody ArticleDTO dto);

    @GetMapping(value = "sm/article/{id}")
    ArticleDTO getArticleById(@PathVariable("id") int articleId);

    @GetMapping(value = "sm/articlec/{code}")
    ArticleDTO getArticleByCode(@PathVariable("code") String articleCode);

    @GetMapping(value = "sm/articles")
    List<ArticleDTO> findAllArticles();

    @DeleteMapping(value="sm/articled/{id}")
    void deleteArticle(@PathVariable("id")int articleID);

}
