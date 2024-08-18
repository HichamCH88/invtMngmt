package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import com.hicham.stockmanagment.Shared.Consts;

public interface ArticleApi {

    @PostMapping(value = Consts.APP_ROOT+"/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDTO save(@RequestBody ArticleDTO dto);

    @GetMapping(value = Consts.APP_ROOT+"/articles/{id}")
    ArticleDTO getArticleById(@PathVariable("id") int articleId);

    @GetMapping(value = Consts.APP_ROOT+"/articles/c/{code}")
    ArticleDTO getArticleByCode(@PathVariable("code") String articleCode);

    @GetMapping(value = Consts.APP_ROOT+"/articles/all")
    List<ArticleDTO> findAllArticles();

    @DeleteMapping(value=Consts.APP_ROOT+"/articles/{id}")
    void deleteArticle(@PathVariable("id")int articleID);

}
