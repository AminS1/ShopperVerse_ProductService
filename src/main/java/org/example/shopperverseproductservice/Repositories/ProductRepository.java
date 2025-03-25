package org.example.shopperverseproductservice.Repositories;

import lombok.NonNull;
import org.example.shopperverseproductservice.Models.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    @NonNull
    Product getReferenceById(@NonNull Long id);

    List<Product> findProductsByTitleContains(String searchText, PageRequest pageRequest);

    List<Product> findProductsByCategoryId(@NonNull Long categoryId);
}