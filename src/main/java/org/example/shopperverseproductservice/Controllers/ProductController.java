package org.example.shopperverseproductservice.Controllers;

import org.example.shopperverseproductservice.Exceptions.ProductNotFoundException;
import org.example.shopperverseproductservice.Models.Product;
import org.example.shopperverseproductservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestHeader("AuthToken") String token) {
        return productService.getAllProducts(token);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id, product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/bulk")
    public List<Product> addBulkProducts(@RequestBody List<Product> products) {
        return productService.addBulkProducts(products);
    }

    @GetMapping("/getByCategory")
    public List<Product> getProductsByCategory(@RequestParam Long categoryId) {
        return this.productService.getProductsByCategory(categoryId);
    }
}
