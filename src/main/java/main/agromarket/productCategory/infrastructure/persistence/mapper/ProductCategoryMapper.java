package main.agromarket.productCategory.infrastructure.persistence.mapper;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.response.ProductCategoryResponseDto;
import main.agromarket.productCategory.infrastructure.persistence.entity.ProductCategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {
    public ProductCategoryEntity domainToEntity(ProductCategory productCategory) {
        return new ProductCategoryEntity(
                productCategory.getName(
                ));
    }

    public ProductCategoryResponseDto entityToDomain(ProductCategoryEntity productCategoryEntity) {
        return ProductCategoryResponseDto.builder()
                .name(productCategoryEntity.getName())
                .id(productCategoryEntity.getId())
                .build();
    }
}