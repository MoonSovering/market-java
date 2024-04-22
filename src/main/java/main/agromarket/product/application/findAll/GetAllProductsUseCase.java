package main.agromarket.product.application.findAll;

import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsUseCase {
    private final ProductRepositoryPort respository;

    public GetAllProductsUseCase(ProductRepositoryPort respository) {
        this.respository = respository;
    }

    public List<Product> findAll(){
        return respository.getAll();
    }
}
