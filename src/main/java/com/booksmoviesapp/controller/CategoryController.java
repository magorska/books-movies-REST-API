package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    public void getCategory() {}

    public void createCategory() {}

    public void updateCategory() {}

    public void deleteCategory() {}
}
