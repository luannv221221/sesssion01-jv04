package com.ra.service;

import com.ra.model.Category;
import com.ra.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(Category category) {
        try {
            this.categoryRepository.save(category);
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean delete(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
