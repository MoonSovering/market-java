package main.agromarket.farmer.infrastructure.rest.controller;

import main.agromarket.farmer.application.findById.FindFarmerByIdUseCase;
import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.domain.ports.out.response.FarmerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FarmerGetByIdController {
    private final FindFarmerByIdUseCase find;

    public FarmerGetByIdController(FindFarmerByIdUseCase find) {
        this.find = find;
    }

    @GetMapping(value = "farmer/get/{id}")
    public ResponseEntity<Optional<FarmerResponseDto>> findById(@PathVariable String id){
        Optional<FarmerResponseDto> farmer = find.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(farmer);
    }
}
