package main.agromarket.product.infrastructure.rest.controller;

import main.agromarket.product.application.findById.FindProductByIdUseCase;
import main.agromarket.product.domain.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class GetProductById {
    private final FindProductByIdUseCase find;

    public GetProductById(FindProductByIdUseCase find) {
        this.find = find;
    }

    @GetMapping(value = "product/get/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable UUID id){
        Optional<Product> result  = find.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }
}
