package main.agromarket.company.domain.ports;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepositoryPort {

    CompanyResponseDto save(Company company);
    void delete(UUID id);
    Optional<CompanyResponseDto> getById(UUID id);
    List<CompanyResponseDto> getAll();
}