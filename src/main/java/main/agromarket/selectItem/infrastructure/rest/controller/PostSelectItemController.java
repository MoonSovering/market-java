package main.agromarket.selectItem.infrastructure.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.agromarket.selectItem.application.create.CreateItemRequest;
import main.agromarket.selectItem.application.create.CreateItemUseCase;
import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostSelectItemController {
    private final CreateItemUseCase create;

    public PostSelectItemController(CreateItemUseCase create) {
        this.create = create;
    }

    @PostMapping(value = "create/item")
    public ResponseEntity<SelectItem> create(@Valid @RequestBody Request request, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        SelectItem body = create.create(new CreateItemRequest(
                request.amountSelect,
                request.idCompany,
                request.idStatus,
                request.idProduct
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Request {
        private int amountSelect;
        private String idCompany;
        private String idStatus;
        private String idProduct;
    }
}
