package main.agromarket.company.infrastructure.persistence.mapper;

import main.agromarket.company.domain.model.*;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;
import main.agromarket.company.infrastructure.persistence.entity.CompanyEntity;
import main.agromarket.company.infrastructure.persistence.entity.ContactAdditionalInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyMapper {

    public CompanyEntity domainToEntity(Company company){
        List<ContactAdditionalInfo> companyContacts = company.getContact().stream()
                .map(contactDetail -> new ContactAdditionalInfo(
                        contactDetail.getTypeContact(),
                        contactDetail.getContact()
                )).toList();
        return new CompanyEntity(
                company.getName().value(),
                companyContacts,
                company.getAddress().value(),
                company.getEmail().value(),
                company.getPassword().value(),
                company.getStatus().value()
        );
    }

    public CompanyResponseDto entityToDomain(CompanyEntity company){
        List<CompanyResponseDto.ContactAdditionalInfo> companyContacts = company.getContact().stream()
                .map(contactAdditionalInfo -> new CompanyResponseDto.ContactAdditionalInfo(
                        contactAdditionalInfo.getContactType(),
                        contactAdditionalInfo.getContact()
                )).toList();
        return new CompanyResponseDto(
                company.getCompanyId(),
                company.getName(),
                companyContacts,
                company.getAddress(),
                company.getEmail(),
                company.getPassword(),
                company.getStatus()
        );
    }
}