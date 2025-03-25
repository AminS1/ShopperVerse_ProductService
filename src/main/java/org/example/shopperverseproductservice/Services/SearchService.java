package org.example.shopperverseproductservice.Services;

import org.example.shopperverseproductservice.Models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    ProductService productService;

    public SearchService(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    public List<Product> search(String searchText, int pageNumber, int pageSize, String sortBy, int sortOrder) {
        return productService.searchProductsByTitle(searchText, pageNumber, pageSize, sortBy, sortOrder);
    }
}
