package main.agromarket.productCategory.infrastructure.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.agromarket.productCategory.application.create.CreateCategoryRequest;
import main.agromarket.productCategory.application.create.CreateCategoryUseCase;
import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.response.ProductCategoryResponseDto;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProductCategoryPostController {
    private final CreateCategoryUseCase createProduct;

    public CreateProductCategoryPostController(CreateCategoryUseCase createProduct) {
        this.createProduct = createProduct;
    }
    @PostMapping(value = "create/product-category")
    public ResponseEntity<ProductCategoryResponseDto> create(@Valid @RequestBody Request request, BindingResult errorResult){
        if (errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }

        ProductCategoryResponseDto result = createProduct.CreateProductCategory(new CreateCategoryRequest(
                request.name
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    private static class Request{
        private String name;
    }
}