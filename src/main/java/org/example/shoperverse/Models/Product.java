package org.example.shoperverse.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    Long id;
    String title;
    String description;
    int price; // in Paise
    Category category;
    String imageUrl;
}
