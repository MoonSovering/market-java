package main.agromarket.productCategory.application.create;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.ProductCategoryRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {
    private final ProductCategoryRepositoryPort repository;

    public CreateCategoryUseCase(ProductCategoryRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductCategory CreateProductCategory(CreateCategoryRequest request){
        ProductCategory product = new ProductCategory(
                request.getName()
        );
        return repository.save(product);
    }
}