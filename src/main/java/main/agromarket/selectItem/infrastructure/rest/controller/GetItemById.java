package main.agromarket.selectItem.infrastructure.rest.controller;

import main.agromarket.selectItem.application.findById.FindItemByIdUseCase;
import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.response.ProductItemResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class GetItemById {
    private final FindItemByIdUseCase find;

    public GetItemById(FindItemByIdUseCase find) {
        this.find = find;
    }

    @GetMapping(value = "select-item/get/{id}")
    public ResponseEntity<Optional<ProductItemResponseDto>> findById(@PathVariable UUID id){
        Optional<ProductItemResponseDto> result = find.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
