package main.agromarket.company.infrastructure.persistence.repository;

import main.agromarket.company.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByEmail(String email);
}
