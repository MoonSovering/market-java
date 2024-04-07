package main.agromarket.company.application.findById;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FindCompanyByIdUseCase {
    private final CompanyRepositoryPort companyRepository;

    public FindCompanyByIdUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }
    public Optional<Company> findCompanyById(String id){
        return companyRepository.getById(id);
    }
}