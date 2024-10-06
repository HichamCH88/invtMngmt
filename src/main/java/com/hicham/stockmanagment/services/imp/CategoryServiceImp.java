package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.CategoryDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.Category;
import com.hicham.stockmanagment.repository.CategoryRepository;
import com.hicham.stockmanagment.services.CategoryService;
import com.hicham.stockmanagment.validator.CategoryValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CategoryServiceImp implements CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImp.class);
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImp( CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        List<String> errors= CategoryValidator.validate(categoryDTO);
        if(!errors.isEmpty()) {
            log.error("invalid category");
            errors.forEach(System.out::println);
            throw new InvalidEntityException("invalid category", ErrorCode.CATEGORY_NOT_VALID,errors);
        }
        return CategoryDTO.fromEntity(categoryRepository.save(CategoryDTO.toEntity(categoryDTO)));
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        System.out.println("updating category");
        Optional<Category> categoryToUpdate=this.categoryRepository.findById(categoryDTO.getId());
        if(categoryToUpdate.isEmpty()) {
            throw new EntityNotFoundException("Cant update unFound categories");
        }else{
            categoryToUpdate.get().setCategoryCode(categoryDTO.getCategoryCode());
            categoryToUpdate.get().setCategoryDesignation(categoryDTO.getCategoryDesignation());
            return CategoryDTO.fromEntity(this.categoryRepository.save(categoryToUpdate.get()));
        }
    }

    @Override
    public CategoryDTO findById(Integer id) {
        if(id==null){
            log.error("Id is null");
            return null;
        }
        Optional<Category> category=categoryRepository.findById(id);
        return Optional.ofNullable(CategoryDTO.fromEntity(category.orElse(null))).orElseThrow(()->
                new EntityNotFoundException("article not found",ErrorCode.CATEGORY_NOT_Found));
    }

    @Override
    public CategoryDTO findByCode(String code) {
        if(code==null){
            log.error("code is null");
            return null;
        }
        Optional<Category> category=categoryRepository.findByCategoryCode(code);
        return Optional.ofNullable(CategoryDTO.fromEntity(category.orElse(null))).orElseThrow(()->
                new EntityNotFoundException("article not found",ErrorCode.CATEGORY_NOT_Found));
    }

    @Override
    public List<CategoryDTO> findAll() {
        return  categoryRepository.findAll().stream().map(CategoryDTO::fromEntity).toList();
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
