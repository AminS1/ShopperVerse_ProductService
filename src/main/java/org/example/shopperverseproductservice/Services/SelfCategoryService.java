package org.example.shopperverseproductservice.Services;

import org.example.shopperverseproductservice.Models.Category;
import org.example.shopperverseproductservice.Repositories.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SelfCategoryService implements CategoryService{
    CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> addBulkCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
}
