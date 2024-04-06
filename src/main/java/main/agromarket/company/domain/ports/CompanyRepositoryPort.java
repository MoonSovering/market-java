package main.agromarket.company.domain.ports;

import main.agromarket.company.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryPort {

    void save(Company company);
    void delete(String id);
    Optional<Company> getById(String id);
    List<Company> getAll();
}