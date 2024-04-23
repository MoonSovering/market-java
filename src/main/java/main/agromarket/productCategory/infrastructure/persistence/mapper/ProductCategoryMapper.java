package main.agromarket.productCategory.infrastructure.persistence.mapper;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.infrastructure.persistence.entity.ProductCategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {
    public ProductCategoryEntity domainToEntity(ProductCategory productCategory) {
        return new ProductCategoryEntity(
                productCategory.getName()
        );
    }

    public ProductCategory entityToDomain(ProductCategoryEntity productCategoryEntity) {
        return new ProductCategory(
                productCategoryEntity.getName()
        );
    }
}