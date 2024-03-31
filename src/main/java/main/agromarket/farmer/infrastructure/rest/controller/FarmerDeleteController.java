package main.agromarket.farmer.infrastructure.rest.controller;

import main.agromarket.farmer.application.delete.DeleteFarmerUseCase;
import main.agromarket.shared.exception.FarmerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmerDeleteController {
    private DeleteFarmerUseCase delete;

    public FarmerDeleteController(DeleteFarmerUseCase delete) {
        this.delete = delete;
    }

    @DeleteMapping(value = "user/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        try {
            delete.deleteFarmer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (FarmerException e){
            return new ResponseEntity<>(e.getErrorMessage(), e.getErrorCode());
        }
    }
}
