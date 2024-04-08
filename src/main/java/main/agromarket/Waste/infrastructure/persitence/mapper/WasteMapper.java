package main.agromarket.Waste.infrastructure.persitence.mapper;

import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import org.springframework.stereotype.Component;

@Component
public class WasteMapper {
    public WasteEntity domainToEntity(Waste waste) {
        WasteEntity wasteEntity = new WasteEntity();
        wasteEntity.setIdFarmer(waste.getIdFarmer());
        wasteEntity.setIdStatus(waste.getIdStatus());
        wasteEntity.setIdProduct(waste.getIdProduct());
        return wasteEntity;
    }

    public Waste entityToDomain(WasteEntity wasteEntity) {
        Waste waste = new Waste();
        waste.setIdFarmer(wasteEntity.getIdFarmer());
        waste.setIdStatus(wasteEntity.getIdStatus());
        waste.setIdProduct(wasteEntity.getIdProduct());
        return waste;
    }
}