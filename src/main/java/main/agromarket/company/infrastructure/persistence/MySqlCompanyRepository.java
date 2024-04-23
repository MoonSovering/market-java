package main.agromarket.company.infrastructure.persistence;

import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.CompanyRepositoryPort;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;
import main.agromarket.company.infrastructure.persistence.entity.CompanyEntity;
import main.agromarket.company.infrastructure.persistence.mapper.CompanyMapper;
import main.agromarket.company.infrastructure.persistence.repository.JpaCompanyRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MySqlCompanyRepository implements CompanyRepositoryPort {
    private final JpaCompanyRepository companyRepository;
    private final CompanyMapper mapper;

    public MySqlCompanyRepository(JpaCompanyRepository companyRepository, CompanyMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public CompanyResponseDto save(Company company) {
        CompanyEntity companyEntity = mapper.domainToEntity(company);
        CompanyEntity result = companyRepository.save(companyEntity);
        return mapper.entityToDomain(result);
    }

    @Override
    public void delete(String id) {
        Optional<CompanyEntity> company = this.companyRepository.findById(id);
        if(company.isEmpty()){
            throw new GeneralException("Company cannot be found.", HttpStatus.BAD_REQUEST);
        }
        companyRepository.deleteById(id);
    }

    @Override
    public Optional<CompanyResponseDto> getById(String id) {
        Optional<CompanyResponseDto> company = this.companyRepository.findById(id)
                .map(mapper::entityToDomain);
        if(company.isEmpty()){
            throw new GeneralException("Company cannot be found.", HttpStatus.BAD_REQUEST);
        }
        return company;
    }

    @Override
    public List<CompanyResponseDto> getAll() {
        List<CompanyEntity> companies = this.companyRepository.findAll();
        if(companies.isEmpty()){
            throw new GeneralException("No companies found in the company list.", HttpStatus.BAD_REQUEST);
        }
        return companies.stream()
                .map(mapper::entityToDomain)
                .toList();
    }
}
