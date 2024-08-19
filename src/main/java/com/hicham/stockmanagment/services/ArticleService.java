package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.ArticleDTO;

import java.util.List;

public interface ArticleService {

    ArticleDTO save(ArticleDTO dto);

    ArticleDTO findById(Integer id);

    ArticleDTO findByCodeArticle(String codeArticle);

    List<ArticleDTO> findAll();

    void delete(Integer id);

    ArticleDTO saveNewArticle(ArticleDTO dto,Integer qty);
}
