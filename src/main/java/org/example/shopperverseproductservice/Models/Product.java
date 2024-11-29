package org.example.shopperverseproductservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity( name = "products" )
@NoArgsConstructor
public class Product extends BaseModel {
    String title;
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Column( length = 1000 )
    String description;
    int price; // in Paise
    @ManyToOne
    Category category;
    String image;
}
