package main.agromarket.selectItem.infrastructure.rest.controller;

import main.agromarket.selectItem.application.findAll.FindAllItemUseCase;
import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.response.ProductItemResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllItemController {
    private final FindAllItemUseCase findAll;

    public GetAllItemController(FindAllItemUseCase findAll) {
        this.findAll = findAll;
    }

    @GetMapping(value = "select-item")
    public ResponseEntity<List<ProductItemResponseDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(findAll.getAll());
    }
}
