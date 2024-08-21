package com.ra.controller;

import com.ra.model.Category;
import com.ra.service.CategoryService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String index(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "category";
    }
    @GetMapping("/add")
    public String add(Model model,Category category){
        model.addAttribute("category",category);
        return "add-category";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "edit-category";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
