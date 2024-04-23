package main.agromarket.productCategory.infrastructure.persistence;

import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.ProductCategoryRepositoryPort;
import main.agromarket.productCategory.domain.ports.out.response.ProductCategoryResponseDto;
import main.agromarket.productCategory.infrastructure.persistence.entity.ProductCategoryEntity;
import main.agromarket.productCategory.infrastructure.persistence.mapper.ProductCategoryMapper;
import main.agromarket.productCategory.infrastructure.persistence.reposity.ProductCategoryJpaRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MySqlProductCategoryRepository implements ProductCategoryRepositoryPort {
    private final ProductCategoryJpaRepository repository;
    private final ProductCategoryMapper mapper;

    public MySqlProductCategoryRepository(ProductCategoryJpaRepository repository, ProductCategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductCategoryResponseDto save(ProductCategory productCategory) {
        ProductCategoryEntity category = mapper.domainToEntity(productCategory);
        ProductCategoryEntity savedEntity = repository.save(category);
        return mapper.entityToDomain(savedEntity);
    }

    @Override
    public List<ProductCategoryResponseDto> getAll() {
        List<ProductCategoryEntity> categories = repository.findAll();
        if(categories.isEmpty()){
            throw new GeneralException("Categories cannot be found.", HttpStatus.BAD_REQUEST);
        }
        return categories.stream()
                .map(mapper::entityToDomain).toList();
    }
}
