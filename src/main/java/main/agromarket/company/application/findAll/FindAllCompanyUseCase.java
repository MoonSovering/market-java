package main.agromarket.company.application.findAll;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FindAllCompanyUseCase {
    private final CompanyRepositoryPort companyRepository;

    public FindAllCompanyUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAllCompany(){
        return companyRepository.getAll();
    }
}
