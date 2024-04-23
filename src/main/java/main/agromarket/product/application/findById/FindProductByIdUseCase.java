package main.agromarket.product.application.findById;

import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindProductByIdUseCase {
    private final ProductRepositoryPort repository;

    public FindProductByIdUseCase(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    public Optional<Product> findById(UUID id){
        return repository.findById(id);
    }
}
