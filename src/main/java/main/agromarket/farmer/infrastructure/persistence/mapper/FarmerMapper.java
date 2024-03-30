package main.agromarket.farmer.infrastructure.persistence.mapper;

import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import org.springframework.stereotype.Component;

@Component
public class FarmerMapper {
    public FarmerEntity domainToEntity(Farmer farmer) {
        return new FarmerEntity(
                farmer.getUserId().value(),
                farmer.getUserName().value(),
                farmer.getEmail().value(),
                farmer.getPassword().value(),
                farmer.getLastName().value(),
                farmer.getAddress().value()

        );
    }
}
