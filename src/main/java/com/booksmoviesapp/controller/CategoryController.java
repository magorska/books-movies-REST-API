package com.booksmoviesapp.controller;

import com.booksmoviesapp.domain.Category;
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
    public void getCategory() {}

    @PostMapping(path = "createCategory")
    public void createCategory() {}

    @PutMapping(path = "updateCategory")
    public void updateCategory() {}

    @DeleteMapping(path = "deleteCategory")
    public void deleteCategory() {}
}
