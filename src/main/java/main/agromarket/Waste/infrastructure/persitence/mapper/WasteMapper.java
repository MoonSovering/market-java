package main.agromarket.Waste.infrastructure.persitence.mapper;

import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import org.springframework.stereotype.Component;

@Component
public class WasteMapper {
    public WasteEntity domainToEntity(Waste waste) {
        return new WasteEntity(
                waste.getIdFarmer(),
                waste.getIdStatus(),
                waste.getIdProduct(),
                waste.getShippingStatus()
        );
    }

    public Waste entityToDomain(WasteEntity wasteEntity) {
        return new Waste(
                wasteEntity.getIdFarmer(),
                wasteEntity.getIdStatus(),
                wasteEntity.getIdProduct(),
                wasteEntity.getShippingStatus()
        );
    }
}