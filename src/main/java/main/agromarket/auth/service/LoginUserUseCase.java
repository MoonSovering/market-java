package main.agromarket.auth.service;

import main.agromarket.auth.dtos.ClientResponseDto;
import main.agromarket.auth.dtos.LoginUserDto;
import main.agromarket.company.infrastructure.persistence.entity.CompanyEntity;
import main.agromarket.company.infrastructure.persistence.repository.JpaCompanyRepository;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.farmer.infrastructure.persistence.repository.JpaUserRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserUseCase {
    private final JpaUserRepository userRepository;
    private final JpaCompanyRepository companyRepository;

    public LoginUserUseCase(JpaUserRepository userRepository, JpaCompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public ClientResponseDto loginUser(LoginUserDto body) {
        Optional<FarmerEntity> farmer = userRepository.findByEmail(body.getEmail());
        Optional<CompanyEntity> company = companyRepository.findByEmail(body.getEmail());

        if (farmer.isPresent()) {
            FarmerEntity f = farmer.get();
            if (!f.getPassword().equals(body.getPassword())) {
                throw new GeneralException("Email or password incorrect.", HttpStatus.BAD_REQUEST);
            }
            return new ClientResponseDto(
                    f.getFarmerId().toString(),
                    f.getEmail(),
                    f.getFarmerName(),
                    f.getStatus()
            );
        } else if (company.isPresent()) {
            CompanyEntity c = company.get();
            if (!c.getPassword().equals(body.getPassword())) {
                throw new GeneralException("Email or password incorrect.", HttpStatus.BAD_REQUEST);
            }
            return new ClientResponseDto(
                    c.getCompanyId().toString(),
                    c.getEmail(),
                    c.getName(),
                    c.getStatus()
            );
        } else {
            throw new GeneralException("Email or password incorrect.", HttpStatus.BAD_REQUEST);
        }
    }
}
