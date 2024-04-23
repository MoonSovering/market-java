package main.agromarket.selectItem.infrastructure.persistence.repository;

import main.agromarket.selectItem.infrastructure.persistence.entity.SelectItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SelectItemJpaRepository extends JpaRepository<SelectItemEntity, UUID> {
}
