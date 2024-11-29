package org.example.shopperverseproductservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.shopperverseproductservice.Models.Category;
import org.example.shopperverseproductservice.Models.Product;

@Setter
@Getter
public class FakeStoreProductDto {
    Long id;
    String title;
    String description;
    int price; // in Paise
    String category;
    String image;

    public Product toModel() {
        Category categoryObj = new Category();
        categoryObj.setTitle(this.category);
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategory(categoryObj);
        product.setImage(this.image);
        return product;
    }
}
