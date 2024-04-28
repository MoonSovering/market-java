package main.agromarket.company.infrastructure.rest.controller;

import main.agromarket.company.application.findById.FindCompanyByIdUseCase;
import main.agromarket.company.domain.model.Company;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CompanyGetByIdController {
    private final FindCompanyByIdUseCase findAll;

    public CompanyGetByIdController(FindCompanyByIdUseCase findAll) {
        this.findAll = findAll;
    }

    @GetMapping(value = "company/{id}")
    public ResponseEntity<Optional<CompanyResponseDto>> findById(@PathVariable UUID id){
        Optional<CompanyResponseDto> company = findAll.findCompanyById(id);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }
}
