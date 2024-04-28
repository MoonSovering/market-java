package main.agromarket.selectItem.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.agromarket.shared.Enum.ShippingStatus;

@Getter
@Setter
@AllArgsConstructor
public class CreateItemRequest {
    private int amountSelect;
    private String idCompany;
    private String idProduct;
    private ShippingStatus shippingStatus;
}
