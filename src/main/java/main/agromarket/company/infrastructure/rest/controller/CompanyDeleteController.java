package main.agromarket.company.infrastructure.rest.controller;

import main.agromarket.company.application.delete.DeleteCompanyUseCase;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyDeleteController {
    private final DeleteCompanyUseCase delete;

    public CompanyDeleteController(DeleteCompanyUseCase delete) {
        this.delete = delete;
    }
    @DeleteMapping(value = "company/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        try {
            delete.deleteCompany(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (GeneralException e){
            return new ResponseEntity<>(e.getErrorMessage(), e.getErrorCode());
        }
    }
}