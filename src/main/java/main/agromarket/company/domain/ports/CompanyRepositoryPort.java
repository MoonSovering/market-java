package main.agromarket.company.domain.ports;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;

import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryPort {

    CompanyResponseDto save(Company company);
    void delete(String id);
    Optional<CompanyResponseDto> getById(String id);
    List<CompanyResponseDto> getAll();
}