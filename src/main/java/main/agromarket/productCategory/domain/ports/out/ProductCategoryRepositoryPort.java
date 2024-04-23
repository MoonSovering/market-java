package main.agromarket.productCategory.domain.ports.out;

import main.agromarket.productCategory.domain.model.ProductCategory;

import java.util.List;

public interface ProductCategoryRepositoryPort {
    ProductCategory save(ProductCategory productCategory);
    List<ProductCategory> getAll();
}
