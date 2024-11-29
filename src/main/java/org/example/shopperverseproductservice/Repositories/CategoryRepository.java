package org.example.shopperverseproductservice.Repositories;

import org.example.shopperverseproductservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
