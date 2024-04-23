package main.agromarket.Waste.domain.ports.out.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.agromarket.shared.Enum.ShippingStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class WasteResponseDto {
    private UUID wasteId;
    private String idFarmer;
    private String idStatus;
    private String idProduct;
    LocalDate publishedDate;
    private ShippingStatus shippingStatus;
}
