package main.agromarket.company.infrastructure.rest.controller;

import main.agromarket.company.application.findById.FindCompanyByIdUseCase;
import main.agromarket.company.domain.model.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class CompanyGetByIdController {
    private final FindCompanyByIdUseCase findAll;

    public CompanyGetByIdController(FindCompanyByIdUseCase findAll) {
        this.findAll = findAll;
    }

    @GetMapping(value = "company/{id}")
    public ResponseEntity<Optional<Company>> findById(@PathVariable String id){
        Optional<Company> company = findAll.findCompanyById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
