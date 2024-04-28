package main.agromarket.company.application.findById;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.CompanyRepositoryPort;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindCompanyByIdUseCase {
    private final CompanyRepositoryPort companyRepository;

    public FindCompanyByIdUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }
    public Optional<CompanyResponseDto> findCompanyById(UUID id){
        return companyRepository.getById(id);
    }
}