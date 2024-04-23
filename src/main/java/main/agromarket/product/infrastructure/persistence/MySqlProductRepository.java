package main.agromarket.product.infrastructure.persistence;

import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.ProductRepositoryPort;
import main.agromarket.product.domain.ports.out.response.ProductResponseDto;
import main.agromarket.product.infrastructure.persistence.entity.ProductEntity;
import main.agromarket.product.infrastructure.persistence.mapper.ProductMapper;
import main.agromarket.product.infrastructure.persistence.repository.ProductJpaRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MySqlProductRepository implements ProductRepositoryPort {

    private final ProductJpaRepository repository;
    private final ProductMapper mapper;


    public MySqlProductRepository(ProductJpaRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductResponseDto save(Product product) {
        ProductEntity productEntity = mapper.domainToEntity(product);
        ProductEntity result =  repository.save(productEntity);
        return mapper.entityToDomain(result);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        List<ProductResponseDto> result = repository.findAll().stream()
                .map(mapper::entityToDomain).toList();

        if(result.isEmpty()){
            throw new GeneralException("Product cannot be found.", HttpStatus.BAD_REQUEST);
        }
        return result;
    }

    @Override
    public Optional<ProductResponseDto> findById(UUID id) {
        Optional<ProductResponseDto> result = repository.findById(id).map(mapper::entityToDomain);
        if(result.isEmpty()){
            throw new GeneralException("No product found with the given ID", HttpStatus.BAD_REQUEST);
        }
        return result;
    }
}
