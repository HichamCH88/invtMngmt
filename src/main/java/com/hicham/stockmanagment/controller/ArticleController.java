package com.hicham.stockmanagment.controller;


import com.hicham.stockmanagment.DTO.ArticleDTO;
import com.hicham.stockmanagment.controller.api.ArticleApi;
import com.hicham.stockmanagment.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {



    private ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService= articleService;
    }


    @Override
    public ArticleDTO save(ArticleDTO dto) {
        return this.articleService.save(dto);
    }

    @Override
    public  ArticleDTO getArticleById( int articleId){return this.articleService.findById(articleId);}

    @Override
    public ArticleDTO getArticleByCode(String articleCode){return this.articleService.findByCodeArticle(articleCode);}

    @Override
    public List<ArticleDTO> findAllArticles() {
        return this.articleService.findAll();
    }

    @Override
    public void deleteArticle(int articleID) {
        this.articleService.delete(articleID);
    }
}
