package main.agromarket.company.infrastructure.rest.controller;

import main.agromarket.company.application.findAll.FindAllCompanyUseCase;
import main.agromarket.company.domain.model.Company;
import main.agromarket.farmer.domain.model.Farmer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyGetController {
    private final FindAllCompanyUseCase findAll;

    public CompanyGetController(FindAllCompanyUseCase findAll) {
        this.findAll = findAll;
    }
    @GetMapping(value = "companies")
    public ResponseEntity<List<Company>> findAll(){
        List<Company> companies = findAll.findAllCompany();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
}