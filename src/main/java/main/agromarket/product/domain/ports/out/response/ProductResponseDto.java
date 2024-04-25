package main.agromarket.product.domain.ports.out.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class ProductResponseDto {
    private UUID id;
    private String name;
    private int stock;
    private String category;
}
