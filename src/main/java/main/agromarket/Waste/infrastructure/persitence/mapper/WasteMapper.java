package main.agromarket.Waste.infrastructure.persitence.mapper;

import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import org.springframework.stereotype.Component;

@Component
public class WasteMapper {
    public WasteEntity domainToEntity(Waste waste) {
        return new WasteEntity(
                waste.getIdProduct(),
                waste.getShippingStatus()
        );
    }

    public WasteResponseDto entityToDomain(WasteEntity wasteEntity) {
        WasteResponseDto.Product product = null;
        if (wasteEntity.getProduct() != null) {
            String productName = wasteEntity.getProduct().getName() != null ? wasteEntity.getProduct().getName() : null;
            Float productPrice = wasteEntity.getProduct().getPrice() != null ? wasteEntity.getProduct().getPrice() : 0.0f;
            String productCategory = wasteEntity.getProduct().getCategory() != null ? wasteEntity.getProduct().getCategory().getName() : null;
            product = new WasteResponseDto.Product(
                    productName,
                    productPrice,
                    wasteEntity.getProduct().getStock(),
                    productCategory
            );
        }

        WasteResponseDto.Farmer farmer = null;
        if (wasteEntity.getFarmer() != null) {
            String farmerName = wasteEntity.getFarmer().getFarmerName() != null ? wasteEntity.getFarmer().getFarmerName() : null;
            String farm = wasteEntity.getFarmer().getType().get(0).getFarm() != null ? wasteEntity.getFarmer().getType().get(0).getFarm() : null;
            String typeFarm = wasteEntity.getFarmer().getType().get(0).getTypeFarm() != null ? wasteEntity.getFarmer().getType().get(0).getTypeFarm() : null;
            farmer = new WasteResponseDto.Farmer(
                    farmerName,
                    farm,
                    typeFarm
            );
        }

        return new WasteResponseDto(
                wasteEntity.getWasteId(),
                farmer,
                wasteEntity.getPublishedDate(),
                wasteEntity.getShippingStatus(),
                product
        );
    }
}