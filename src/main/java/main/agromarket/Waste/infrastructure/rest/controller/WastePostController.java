package main.agromarket.Waste.infrastructure.rest.controller;

import jakarta.validation.Valid;
import lombok.*;
import main.agromarket.Waste.application.create.CreateWasteRequest;
import main.agromarket.Waste.application.create.CreateWasteUseCase;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import main.agromarket.farmer.application.create.CreateFarmerUseCase;
import main.agromarket.shared.Enum.ShippingStatus;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class WastePostController {
    private CreateWasteUseCase create;

    public WastePostController(CreateWasteUseCase create) {
        this.create = create;
    }

    @PostMapping("waste/create")
    public ResponseEntity<WasteResponseDto> create(@Valid @RequestBody Request request, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        WasteResponseDto result = create.createWaste(new CreateWasteRequest(
                request.idFarmer,
                request.idStatus,
                request.idProduct,
                ShippingStatus.ONWAY
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @AllArgsConstructor
    @Getter
    @Setter
    final static class Request {
        private String idFarmer;
        private String idStatus;
        private String idProduct;
    }
}
