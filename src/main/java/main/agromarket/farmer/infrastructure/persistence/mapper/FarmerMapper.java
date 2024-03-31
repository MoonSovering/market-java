package main.agromarket.farmer.infrastructure.persistence.mapper;


import main.agromarket.farmer.domain.model.*;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.shared.Enum.Status;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Component
public class FarmerMapper {
    public FarmerEntity domainToEntity(Farmer farmer) {
        return new FarmerEntity(
                farmer.getUser().value(),
                farmer.getName().value(),
                farmer.getEmail().value(),
                farmer.getPassword().value(),
                farmer.getLastName().value(),
                farmer.getAddress().value(),
                farmer.getContact().value(),
                farmer.getType().value(),
                farmer.getStatus().value()
        );
    }
    public Farmer entityToDomain(FarmerEntity entity) {
        return new Farmer(
                new FarmerId(entity.getFarmerId()),
                new FarmerName(entity.getFarmerName()),
                new FarmerEmail(entity.getEmail()),
                new FarmerPassword(entity.getPassword()),
                new FarmerLastName(entity.getLastName()),
                new FarmerAddress(entity.getAddress()),
                new FarmerContact(entity.getContact()),
                new FarmType(entity.getType()),
                new FarmerStatus(Status.valueOf(entity.getStatus()))
        );
    }
}