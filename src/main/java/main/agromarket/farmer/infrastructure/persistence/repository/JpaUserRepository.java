package main.agromarket.farmer.infrastructure.persistence.repository;

import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<FarmerEntity, String> {
}
