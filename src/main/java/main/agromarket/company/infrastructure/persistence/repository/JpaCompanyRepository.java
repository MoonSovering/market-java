package main.agromarket.company.infrastructure.persistence.repository;

import main.agromarket.company.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCompanyRepository extends JpaRepository<CompanyEntity, String> {
}
