package org.example.shopperverseproductservice.Services;

import org.example.shopperverseproductservice.Exceptions.ProductNotFoundException;
import org.example.shopperverseproductservice.Models.Category;
import org.example.shopperverseproductservice.Models.Product;
import org.example.shopperverseproductservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service( value = "selfProductService" )
public class SelfProductService implements ProductService {
    ProductRepository productRepository;
    CategoryService categoryService;
    RestTemplate restTemplate;

    public SelfProductService(ProductRepository productRepository, CategoryService categoryService, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.restTemplate = restTemplate;
    }

    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProducts(String token) {
        System.out.println("getAllProducts");
        Object user = restTemplate.getForObject(
                "http://localhost:8082/token/validate/" + token ,
               Object.class
        );
        if(user == null) {
            throw new RuntimeException("Invalid token");
        }
        System.out.println("Token Verified");
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null) {
            Category newCategory = categoryService.addCategory(category);
            product.setCategory(newCategory);
        }
//        else {
//            // check if the category is correct
//        }
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return productRepository.save(product);
        } else {
            throw new ProductNotFoundException(100L, id);
        }
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> addBulkProducts(List<Product> products) {
      return productRepository.saveAll(products);
    }
}
