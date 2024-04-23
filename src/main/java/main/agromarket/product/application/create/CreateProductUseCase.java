package main.agromarket.product.application.create;

import lombok.Getter;
import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.ProductRepositoryPort;
import main.agromarket.product.domain.ports.out.response.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {
    private final ProductRepositoryPort repository;

    public CreateProductUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductResponseDto createProduct(CreateProductRequest request){
        Product product = new Product(
                request.getName(),
                request.getStock(),
                request.getIdCategory()
        );
        return this.repository.save(product);
    }
}
