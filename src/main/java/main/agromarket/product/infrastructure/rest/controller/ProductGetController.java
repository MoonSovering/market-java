package main.agromarket.product.infrastructure.rest.controller;

import main.agromarket.product.application.findAll.GetAllProductsUseCase;
import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.response.ProductResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductGetController {
    private final GetAllProductsUseCase getAll;

    public ProductGetController(GetAllProductsUseCase getAll) {
        this.getAll = getAll;
    }

    @GetMapping(value = "product")
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(getAll.findAll());
    }
}
