package main.agromarket.product.domain.ports.out;

import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.response.ProductResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    ProductResponseDto save(Product product);
    List<ProductResponseDto> getAll();
    Optional<ProductResponseDto> findById(UUID id);
}
