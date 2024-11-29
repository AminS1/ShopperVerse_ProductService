//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.ResponseExtractor;
//import org.springframework.web.client.RestTemplate;
//
//@Service( value = "fakeStoreProductService" )
//public class FakeStoreProductService implements ProductService {
//
//    RestTemplate restTemplate;
//
//    public FakeStoreProductService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @Override
//    public Product getProductById(Long id) {
//        try {
//            FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
//                    "https://fakestoreapi.com/products/" + id,
//                    FakeStoreProductDto.class
//            );
//            if(fakeStoreProductDto == null) {
//                throw new ProductNotFoundException(100L, id);
//            }
//            return fakeStoreProductDto.toModel();
//        } catch (ProductNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setTitle(product.getTitle());
//        fakeStoreProductDto.setDescription(product.getDescription());
//        fakeStoreProductDto.setPrice(product.getPrice());
//
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(
//                fakeStoreProductDto,
//                FakeStoreProductDto.class
//        );
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
//                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//
//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoUpdatedResponseEntity = restTemplate.execute(
//                "https://fakestoreapi.com/products/" + id,
//                HttpMethod.PUT,
//                requestCallback,
//                responseExtractor
//        );
//
//
//        if(fakeStoreProductDtoUpdatedResponseEntity == null || fakeStoreProductDtoUpdatedResponseEntity.getBody() == null) {
//            throw new ProductNotFoundException(100L, id);
//        }
//
//        System.out.println(product.getTitle());
//        return fakeStoreProductDtoUpdatedResponseEntity.getBody().toModel();
//    }
//
//    @Override
//    public Product addProduct(Product product) {
//        return null;
//    }
//}
