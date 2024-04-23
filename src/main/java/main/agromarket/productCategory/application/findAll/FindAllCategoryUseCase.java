package main.agromarket.productCategory.application.findAll;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.ProductCategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategoryUseCase {
    private final ProductCategoryRepositoryPort repository;

    public FindAllCategoryUseCase(ProductCategoryRepositoryPort repository) {
        this.repository = repository;
    }

    public List<ProductCategory> getAll(){
        return repository.getAll();
    }
}
