package main.agromarket.selectItem.domain.ports.out.response;

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
public class ProductItemResponseDto {
    private UUID id;
    private int amountSelect;
    private LocalDate date;
    private String idCompany;
    private String idProduct;
    private ShippingStatus shippingStatus;
}
