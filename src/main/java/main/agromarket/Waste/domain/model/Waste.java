package main.agromarket.Waste.domain.model;


import lombok.*;
import main.agromarket.shared.Enum.ShippingStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Waste {
    private String idFarmer;
    private String idProduct;
    private ShippingStatus shippingStatus;
}
