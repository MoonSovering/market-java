package main.agromarket.selectItem.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateItemRequest {
    private int amountSelect;
    private String idCompany;
    private String idStatus;
    private String idProduct;
}
