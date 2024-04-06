package main.agromarket.company.application.findAll;

import main.agromarket.company.domain.ports.CompanyRepositoryPort;

public class FindAllCompanyUseCase {
    private final CompanyRepositoryPort companyRepository;

    public FindAllCompanyUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void findAllCompany(){
        companyRepository.getAll();
    }
}
