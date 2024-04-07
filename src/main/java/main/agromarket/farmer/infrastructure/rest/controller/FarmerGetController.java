package main.agromarket.farmer.infrastructure.rest.controller;

import main.agromarket.farmer.application.findAll.FindAllFarmerUseCase;
import main.agromarket.farmer.domain.model.Farmer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FarmerGetController {
    private FindAllFarmerUseCase find;

    public FarmerGetController(FindAllFarmerUseCase find) {
        this.find = find;
    }

    @GetMapping(value = "farmer")
    public ResponseEntity<List<Farmer>> findAll(){
        List<Farmer> farmers = find.findAll();
        return new ResponseEntity<>(farmers, HttpStatus.OK);
    }
}
