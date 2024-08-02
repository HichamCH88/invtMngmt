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

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository)
        {
            this.articleRepository=articleRepository;
        }

    @Override
    public ArticleDTO save(ArticleDTO dto) {
        List<String> errors= ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article not valid {}",dto);
            errors.forEach(System.out::println);
            throw new InvalidEntityException("This article is invalid", ErrorCode.ARTICLE_NOT_Valid,errors);

        }
        if(articleRepository.findByArticleCode(dto.getArticleCode())!=null){
            throw new InvalidEntityException("Article with this code already exist");
        }
        return ArticleDTO.fromEntity(articleRepository.save(ArticleDTO.toEntity(dto)));
    }

    @Override
    public ArticleDTO findById(Integer id) {
        if(id==null){
            log.error("article id is null");
            return null;
        }
        Optional<Article> article=articleRepository.findById(id);

        return Optional.ofNullable(ArticleDTO.fromEntity(article.orElse(null))).orElseThrow(() ->
                new EntityNotFoundException("Article with id:"+id+"not found",ErrorCode.ARTICLE_NOT_Found));
    }

    @Override
    public ArticleDTO findByCodeArticle(String articleCode) {
        if(articleCode==null){
            log.error("Article code is null");
            return null;
        }
        Article article=articleRepository.findByArticleCode(articleCode);
        return Optional.ofNullable(ArticleDTO.fromEntity(article)).orElseThrow(()->
                new EntityNotFoundException("Article with Code:"+articleCode+"not found",ErrorCode.ARTICLE_NOT_Found));

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
