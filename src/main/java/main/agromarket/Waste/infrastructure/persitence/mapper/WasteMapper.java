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
        WasteResponseDto.Product product = new WasteResponseDto.Product(
                wasteEntity.getProduct().getName(),
                wasteEntity.getProduct().getStock(),
                wasteEntity.getProduct().getCategory().getName()
        );
        WasteResponseDto.Farmer farmer = new WasteResponseDto.Farmer(
                wasteEntity.getFarmer().getFarmerName(),
                wasteEntity.getFarmer().getType().get(0).getFarm(),
                wasteEntity.getFarmer().getType().get(0).getTypeFarm()
        );
        return new WasteResponseDto(
                wasteEntity.getWasteId(),
                farmer,
                wasteEntity.getPublishedDate(),
                wasteEntity.getShippingStatus(),
                product
        );
    }
}