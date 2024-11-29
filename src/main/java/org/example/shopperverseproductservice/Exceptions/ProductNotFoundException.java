package org.example.shopperverseproductservice.Exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception {
    private final Long id;

    public ProductNotFoundException(Long errorId, Long productId) {
        super("Product not found: " + productId);
        this.id = errorId;
    }
}
