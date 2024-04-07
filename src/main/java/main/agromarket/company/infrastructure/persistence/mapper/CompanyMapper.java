package main.agromarket.company.infrastructure.persistence.mapper;

import main.agromarket.company.domain.model.*;
import main.agromarket.company.infrastructure.persistence.entity.CompanyEntity;
import main.agromarket.company.infrastructure.persistence.entity.ContactDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyMapper {

    public CompanyEntity domainToEntity(Company company){
        List<ContactDetail> companyContacts = company.getContact().stream()
                .map(contactDetail -> new ContactDetail(
                        contactDetail.getTypeContact(),
                        contactDetail.getContact()
                )).toList();
        return new CompanyEntity(
                company.getCompanyId().value(),
                company.getName().value(),
                companyContacts,
                company.getAddress().value(),
                company.getEmail().value(),
                company.getPassword().value(),
                company.getStatus().value()
        );
    }

    public Company entityToDomain(CompanyEntity company){
        List<CompanyContact> companyContacts = company.getContact().stream()
                .map(contactDetail -> new CompanyContact(
                        contactDetail.getContactType(),
                        contactDetail.getContact()
                )).toList();
        return new Company(
                new CompanyId(company.getCompanyId()),
                new CompanyName(company.getName()),
                companyContacts,
                new CompanyAddress(company.getAddress()),
                new CompanyEmail(company.getEmail()),
                new CompanyPassword(company.getPassword()),
                new CompanyStatus(company.getStatus())
        );
    }
}