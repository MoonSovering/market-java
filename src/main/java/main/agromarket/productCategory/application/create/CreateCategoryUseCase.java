package main.agromarket.productCategory.application.create;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.ProductCategoryRepositoryPort;
import main.agromarket.productCategory.domain.ports.out.response.ProductCategoryResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {
    private final ProductCategoryRepositoryPort repository;

    public CreateCategoryUseCase(ProductCategoryRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductCategoryResponseDto CreateProductCategory(CreateCategoryRequest request){
        ProductCategory product = new ProductCategory(
                request.getName()
        );
        return repository.save(product);
    }
}