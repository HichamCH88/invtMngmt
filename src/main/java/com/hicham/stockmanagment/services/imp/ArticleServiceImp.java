package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.ArticleDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.repository.ArticleRepository;
import com.hicham.stockmanagment.services.ArticleService;
import com.hicham.stockmanagment.validator.ArticleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImp implements ArticleService {


    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImp.class);

    private ArticleRepository articleRepository;

    @Autowired//
    public ArticleServiceImp(ArticleRepository articleRepository)
        {
            this.articleRepository=articleRepository;
        }

    @Override
    public ArticleDTO save(ArticleDTO dto) {
        //check if articleDTO is valid and not null
        List<String> errors= ArticleValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("Article not valid {}",dto);
            errors.forEach(System.out::println);
            throw new InvalidEntityException("This article is invalid", ErrorCode.ARTICLE_NOT_Valid,errors);

        }
        //check if article code exist(article code must be unique)
        if(articleRepository.findByArticleCode(dto.getArticleCode())!=null){
            throw new InvalidEntityException("Article with this code already exist");
        }
        //save article to database
        return ArticleDTO.fromEntity(articleRepository.save(ArticleDTO.toEntity(dto)));
    }

    @Override
    public ArticleDTO findById(Integer id) {
        if(id==null){
            log.error("article id is null");
            return null;
        }
        //get article (id) from the database
        Optional<Article> article=articleRepository.findById(id);
        //if result is null/does not exist throw exception
        if(article.isEmpty()){
            log.warn("Article not found");
            throw  new EntityNotFoundException("Article with id:"+id+"not found",ErrorCode.ARTICLE_NOT_Found);
        }

        return ArticleDTO.fromEntity(article.get());

    }

    @Override
    public ArticleDTO findByCodeArticle(String articleCode) {
        if(articleCode==null){
            log.error("Article code is null");
            return null;
        }
        Article article=articleRepository.findByArticleCode(articleCode);
        if(article==null){
            log.warn("Article does not exist");
            throw  new EntityNotFoundException("Article with code:"+articleCode+"not found",ErrorCode.ARTICLE_NOT_Found);
        }
        return ArticleDTO.fromEntity(article);

    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleRepository.findAll().stream().map(ArticleDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        articleRepository.deleteById(id);

    }
}
