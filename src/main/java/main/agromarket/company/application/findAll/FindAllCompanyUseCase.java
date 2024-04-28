package main.agromarket.company.application.findAll;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.CompanyRepositoryPort;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FindAllCompanyUseCase {
    private final CompanyRepositoryPort companyRepository;

    public FindAllCompanyUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyResponseDto> findAllCompany(){
        return companyRepository.getAll();
    }
}
