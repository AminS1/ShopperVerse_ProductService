package org.example.shopperverseproductservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDto {
    private Long errorCode;
    private String errorMessage;
}
