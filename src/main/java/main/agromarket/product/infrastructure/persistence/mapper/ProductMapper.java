package main.agromarket.product.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import main.agromarket.product.domain.model.Product;
import main.agromarket.product.infrastructure.persistence.entity.ProductEntity;

@Component
public class ProductMapper {
    public ProductEntity domainToEntity(Product product) {
        return new ProductEntity(
                product.getName(),
                product.getStock(),
                product.getIdCategory()
        );
    }

    public Product entityToDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getName(),
                productEntity.getStock(),
                productEntity.getIdCategory()
        );
    }
}