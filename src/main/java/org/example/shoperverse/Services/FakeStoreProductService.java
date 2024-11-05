package org.example.shoperverse.Services;

import org.example.shoperverse.DTOs.FakeStoreProductDto;
import org.example.shoperverse.Models.Category;
import org.example.shoperverse.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        try {
            FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                    "https://fakestoreapi.com/products/" + id,
                    FakeStoreProductDto.class
            );
            if(fakeStoreProductDto == null) {
                throw new RestClientException("Could not find product with id: " + id);
            }
            return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Category category = new Category(fakeStoreProductDto.getCategory());
        return new Product(
                fakeStoreProductDto.getId(),
                fakeStoreProductDto.getTitle(),
                fakeStoreProductDto.getDescription(),
                fakeStoreProductDto.getPrice(),
                category,
                fakeStoreProductDto.getImage()
        );
    }
}
