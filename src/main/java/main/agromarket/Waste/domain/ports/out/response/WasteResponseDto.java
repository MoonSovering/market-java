package main.agromarket.Waste.domain.ports.out.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.shared.Enum.ShippingStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class WasteResponseDto {
    private UUID wasteId;
    private Farmer farmer;
    LocalDate publishedDate;
    private ShippingStatus shippingStatus;
    private Product product;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Product {
        private String name;
        private int stock;
        private String category;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Farmer {
        private String name;
        private String farm;
        private String farmType;
    }
}
