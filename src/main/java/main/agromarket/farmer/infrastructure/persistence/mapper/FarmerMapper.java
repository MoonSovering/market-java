package main.agromarket.farmer.infrastructure.persistence.mapper;


import main.agromarket.farmer.domain.model.*;
import main.agromarket.farmer.domain.ports.out.response.FarmerResponseDto;
import main.agromarket.farmer.infrastructure.persistence.entity.ContactAdditionalInfoEntity;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmTypeInformationEntity;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FarmerMapper {
    public FarmerEntity domainToEntity(Farmer farmer) {
        List<ContactAdditionalInfoEntity> farmerContacts = farmer.getContact().stream()
                .map(contactDetail -> new ContactAdditionalInfoEntity(
                        contactDetail.getTypeContact(),
                        contactDetail.getContact()
                )).toList();
        List<FarmTypeInformationEntity> typeInfos = farmer.getType().stream()
                .map(farmType -> new FarmTypeInformationEntity(
                        farmType.getTypeFarm(),
                        farmType.getFarm()
                )).toList();
        return new FarmerEntity(
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
    public FarmerResponseDto entityToDomain(FarmerEntity entity) {
        List<FarmerResponseDto.ContactAdditionalInfo> companyContacts = entity.getContact().stream()
                .map(contactAdditionalInfoEntity -> new FarmerResponseDto.ContactAdditionalInfo(
                        contactAdditionalInfoEntity.getContactType(),
                        contactAdditionalInfoEntity.getContact()
                )).toList();
        List<FarmerResponseDto.FarmTypeInfo> farmTypes = entity.getType().stream()
                .map(farmTypeInfo -> new FarmerResponseDto.FarmTypeInfo(
                        farmTypeInfo.getTypeFarm(),
                        farmTypeInfo.getFarm()
                )).toList();
        List<FarmerResponseDto.WasteResponse> wastes = null;
        if (entity.getWastes() != null) {
            wastes = entity.getWastes().stream()
                    .map(waste -> new FarmerResponseDto.WasteResponse(
                            waste.getPublishedDate(),
                            waste.getShippingStatus().toString(),
                            waste.getProduct().getName(),
                            waste.getProduct().getCategory().getName(),
                            waste.getProduct().getPrice(),
                            waste.getProduct().getStock()
                    )).toList();
        }
        return new FarmerResponseDto(
                entity.getFarmerId(),
                entity.getFarmerName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getLastName(),
                entity.getAddress(),
                companyContacts,
                farmTypes,
                wastes,
                entity.getStatus()
        );
    }
}