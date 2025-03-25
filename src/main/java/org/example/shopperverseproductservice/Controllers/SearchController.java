package org.example.shopperverseproductservice.Controllers;

import org.example.shopperverseproductservice.Models.Product;
import org.example.shopperverseproductservice.Services.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public List<Product> search(
            @RequestParam("searchText") String searchText,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "price") String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "1") int sortOrder
    ) {
        return searchService.search(searchText, pageNumber, pageSize, sortBy, sortOrder);
    }
}
