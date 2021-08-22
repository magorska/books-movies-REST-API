package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.dto.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @GetMapping(path = "getAllCategories")
    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    @GetMapping(path = "getCategory")
    public CategoryDto getCategory(Long categoryId) {
        return new CategoryDto(1L, "categoryName", new ArrayList<>(), new ArrayList<>());
    }

    @PostMapping(path = "createCategory")
    public void createCategory(CategoryDto categoryDto) {}

    @PutMapping(path = "updateCategory")
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return new CategoryDto(1L, "categoryName", new ArrayList<>(), new ArrayList<>());
    }

    @DeleteMapping(path = "deleteCategory")
    public void deleteCategory(Long categoryId) {}
}
