package main.agromarket.productCategory.infrastructure.persistence.reposity;

import main.agromarket.productCategory.infrastructure.persistence.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCategoryJpaRepository extends JpaRepository<ProductCategoryEntity, UUID> {
}
