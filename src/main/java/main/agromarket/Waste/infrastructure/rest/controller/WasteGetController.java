package main.agromarket.Waste.infrastructure.rest.controller;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.application.findAll.FindAllWasteUseCase;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WasteGetController {
    private final FindAllWasteUseCase find;

    @GetMapping(value = "waste")
    public ResponseEntity<List<WasteResponseDto>> findAll(){
        List<WasteResponseDto> wastes = find.findAllWaste();
        return new ResponseEntity<>(wastes, HttpStatus.OK);
    }
}
