package org.example.shoperverse.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    Long id;
    String title;

    public Category(String title) {
        this.title = title;
    }
}
