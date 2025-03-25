package org.example.shopperverseproductservice.Services;

import org.example.shopperverseproductservice.Models.Category;

import java.util.List;


public interface CategoryService {
    Category addCategory(Category category);

    List<Category> addBulkCategories(List<Category> categories);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();
}
