package main.agromarket.product.infrastructure.persistence.mapper;

import main.agromarket.product.domain.ports.out.response.ProductResponseDto;
import org.springframework.stereotype.Component;
import main.agromarket.product.domain.model.Product;
import main.agromarket.product.infrastructure.persistence.entity.ProductEntity;

@Component
public class ProductMapper {
    public ProductEntity domainToEntity(Product product) {
        return new ProductEntity(
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }

    public ProductResponseDto entityToDomain(ProductEntity productEntity) {
        String category = productEntity.getCategory() != null ? productEntity.getCategory().getName() : null;
        Float price = productEntity.getPrice() != null ? productEntity.getPrice() : 0.0f;
        return new ProductResponseDto(
                productEntity.getId(),
                productEntity.getName(),
                price,
                productEntity.getStock(),
                category
        );
    }
}