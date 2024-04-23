package main.agromarket.productCategory.domain.ports.out;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.response.ProductCategoryResponseDto;

import java.util.List;

public interface ProductCategoryRepositoryPort {
    ProductCategoryResponseDto save(ProductCategory productCategory);
    List<ProductCategoryResponseDto> getAll();
}
