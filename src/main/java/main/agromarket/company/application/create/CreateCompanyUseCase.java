package main.agromarket.company.application.create;

import main.agromarket.company.domain.model.*;
import main.agromarket.company.domain.ports.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreateCompanyUseCase {
    private final CompanyRepositoryPort companyRepository;

    public CreateCompanyUseCase(CompanyRepositoryPort companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void createCompany(CreateCompanyRequest request){
        List<CompanyContact> companyContacts = request.contact().stream()
                .map(contactDetail -> new CompanyContact(
                        contactDetail.contactType(),
                        contactDetail.contact()
                )).toList();
        Company company = new Company(
                new CompanyId(request.companyId()),
                new CompanyName(request.name()),
                companyContacts,
                new CompanyAddress(request.address()),
                new CompanyEmail(request.email()),
                new CompanyPassword(request.password()),
                new CompanyStatus(request.status().toString())
        );
        companyRepository.save(company);
    }
}
