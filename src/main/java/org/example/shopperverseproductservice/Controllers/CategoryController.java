package org.example.shopperverseproductservice.Controllers;

import org.example.shopperverseproductservice.Models.Category;
import org.example.shopperverseproductservice.Services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("/bulk")
    public List<Category> addBulkCategories(@RequestBody List<Category> categories) {
        return categoryService.addBulkCategories(categories);
    }
}
