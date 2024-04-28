package main.agromarket.Waste.infrastructure.rest.controller;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.application.findById.FindWasteByIdUseCase;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class WasteGetByIdController {
    private final FindWasteByIdUseCase find;
    @GetMapping(value = "waste/get/{id}")
    public ResponseEntity<Optional<WasteResponseDto>> findById(@PathVariable UUID id){
        Optional<WasteResponseDto> waste = find.findById(id);
        return new ResponseEntity<>(waste, HttpStatus.OK);
    }
}
