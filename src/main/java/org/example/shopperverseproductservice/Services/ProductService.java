package org.example.shopperverseproductservice.Services;

import org.example.shopperverseproductservice.Exceptions.ProductNotFoundException;
import org.example.shopperverseproductservice.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

//    Product updateProduct(Product product);

    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

    Product addProduct(Product product);

    List<Product> addBulkProducts(List<Product> products);

    List<Product> getAllProducts(String token);


    Product updateProduct(Long id,Product product) throws ProductNotFoundException;

    void deleteProduct(Long id);

    List<Product> searchProductsByTitle(String category, int pageNumber, int pageSize, String sortBy, int sortOrder);

    List<Product> getProductsByCategory(Long categoryId);
}
