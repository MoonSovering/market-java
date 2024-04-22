package main.agromarket.product.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductRequest {
    private String name;
    private int stock;
    private String idCategory;
}
