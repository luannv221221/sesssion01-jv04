package com.ra.service;

import com.ra.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<Category> getAll();
    Category findById(Long id);
    Boolean save(Category category);
    Boolean delete(Long id);
}
