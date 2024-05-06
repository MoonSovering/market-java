package main.agromarket.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private String name;
    private float price;
    private int stock;
    private String idCategory;
}
