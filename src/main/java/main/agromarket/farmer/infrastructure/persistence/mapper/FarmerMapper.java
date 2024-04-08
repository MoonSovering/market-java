package main.agromarket.farmer.infrastructure.persistence.mapper;


import main.agromarket.farmer.domain.model.*;
import main.agromarket.farmer.infrastructure.persistence.entity.ContactAdditionalInfo;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmTypeInfo;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.shared.Enum.Status;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FarmerMapper {
    public FarmerEntity domainToEntity(Farmer farmer) {
        List<ContactAdditionalInfo> farmerContacts = farmer.getContact().stream()
                .map(contactDetail -> new ContactAdditionalInfo(
                        contactDetail.getTypeContact(),
                        contactDetail.getContact()
                )).toList();
        List<FarmTypeInfo> typeInfos = farmer.getType().stream()
                .map(farmType -> new FarmTypeInfo(
                        farmType.getTypeFarm(),
                        farmType.getFarm()
                )).toList();
        return new FarmerEntity(
                farmer.getUser().value(),
                farmer.getName().value(),
                farmer.getEmail().value(),
                farmer.getPassword().value(),
                farmer.getLastName().value(),
                farmer.getAddress().value(),
                farmerContacts,
                typeInfos,
                farmer.getStatus().value()
        );
    }
    public Farmer entityToDomain(FarmerEntity entity) {
        List<FarmerContact> companyContacts = entity.getContact().stream()
                .map(contactAdditionalInfo -> new FarmerContact(
                        contactAdditionalInfo.getContactType(),
                        contactAdditionalInfo.getContact()
                )).toList();
        List<FarmType> farmTypes = entity.getType().stream()
                .map(farmTypeInfo -> new FarmType(
                        farmTypeInfo.getTypeFarm(),
                        farmTypeInfo.getFarm()
                )).toList();
        return new Farmer(
                new FarmerId(entity.getFarmerId()),
                new FarmerName(entity.getFarmerName()),
                new FarmerEmail(entity.getEmail()),
                new FarmerPassword(entity.getPassword()),
                new FarmerLastName(entity.getLastName()),
                new FarmerAddress(entity.getAddress()),
                companyContacts,
                farmTypes,
                new FarmerStatus(Status.valueOf(entity.getStatus()))
        );
    }
}