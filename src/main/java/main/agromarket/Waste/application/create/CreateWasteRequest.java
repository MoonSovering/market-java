package main.agromarket.Waste.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.agromarket.shared.Enum.ShippingStatus;

@AllArgsConstructor
@Getter
@Setter
public class CreateWasteRequest {

    private String idFarmer;
    private String idStatus;
    private String idProduct;
    private ShippingStatus shippingStatus;

}
