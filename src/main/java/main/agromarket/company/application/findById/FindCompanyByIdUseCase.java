package main.agromarket.company.application.findById;

import main.agromarket.company.domain.ports.CompanyRepositoryPort;

public class FindCompanyByIdUseCase {
    private final CompanyRepositoryPort companyRepository;

    public FindCompanyByIdUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }
    public void findCompanyById(String id){
        companyRepository.getById(id);
    }
}