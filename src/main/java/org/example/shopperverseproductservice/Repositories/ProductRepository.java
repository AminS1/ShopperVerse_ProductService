package org.example.shopperverseproductservice.Repositories;

import lombok.NonNull;
import org.example.shopperverseproductservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    @NonNull
    Product getReferenceById(@NonNull Long id);
}