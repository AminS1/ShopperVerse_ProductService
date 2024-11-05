package org.example.shoperverse.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FakeStoreProductDto {
    Long id;
    String title;
    int price; // in Paise
    String category;
    String description;
    String image;
}
