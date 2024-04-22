package main.agromarket.product.domain.ports.out;

import main.agromarket.product.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> getAll();
    Optional<Product> findById(UUID id);
}
