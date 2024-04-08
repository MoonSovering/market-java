package main.agromarket.Waste.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateWasteRequest {

    private String idFarmer;
    private String idStatus;
    private String idProduct;

}
