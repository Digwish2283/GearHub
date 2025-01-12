package com.sheryians.ecommerce.service;

import com.sheryians.ecommerce.model.Category;
import com.sheryians.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void removeCategoryById(int id){categoryRepository.deleteById(id);}

    public Optional getCategoryById(int id){return categoryRepository.findById(id);}

}
