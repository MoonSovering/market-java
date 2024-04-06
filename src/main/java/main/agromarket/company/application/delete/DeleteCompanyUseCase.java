package main.agromarket.company.application.delete;

import main.agromarket.company.domain.ports.CompanyRepositoryPort;

public class DeleteCompanyUseCase {
    private final CompanyRepositoryPort companyRepository;
    public DeleteCompanyUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }
    public void deleteCompany(String id){
        companyRepository.delete(id);
    }
}
