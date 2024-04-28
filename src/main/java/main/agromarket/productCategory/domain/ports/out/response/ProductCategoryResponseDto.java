package main.agromarket.productCategory.domain.ports.out.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductCategoryResponseDto {
    private UUID id;
    private String name;
}
