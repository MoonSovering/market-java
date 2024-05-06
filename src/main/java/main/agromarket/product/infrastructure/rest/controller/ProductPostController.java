package main.agromarket.product.infrastructure.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.agromarket.product.application.create.CreateProductRequest;
import main.agromarket.product.application.create.CreateProductUseCase;
import main.agromarket.product.domain.model.Product;
import main.agromarket.product.domain.ports.out.response.ProductResponseDto;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPostController {
    private final CreateProductUseCase create;

    public ProductPostController(CreateProductUseCase create) {
        this.create = create;
    }

    @PostMapping(value = "create/product")
    public ResponseEntity<ProductResponseDto> create(@Valid @RequestBody Request request, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        ProductResponseDto result = create.createProduct(new CreateProductRequest(
                request.name,
                request.getPrice(),
                request.stock,
                request.category_id
        ));

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static final class Request {
        private String name;
        private float price;
        private int stock;
        private String category_id;
    }
}
