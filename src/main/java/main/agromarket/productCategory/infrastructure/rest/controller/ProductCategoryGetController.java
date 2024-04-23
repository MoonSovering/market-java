package main.agromarket.productCategory.infrastructure.rest.controller;

import main.agromarket.productCategory.application.findAll.FindAllCategoryUseCase;
import main.agromarket.productCategory.domain.model.ProductCategory;
import main.agromarket.productCategory.domain.ports.out.response.ProductCategoryResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryGetController {
    private final FindAllCategoryUseCase find;

    public ProductCategoryGetController(FindAllCategoryUseCase find) {
        this.find = find;
    }

    @GetMapping(value = "product-category")
    public ResponseEntity<List<ProductCategoryResponseDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(find.getAll());
    }
}
