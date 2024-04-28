package main.agromarket.selectItem.infrastructure.persistence.mapper;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.response.ProductItemResponseDto;
import main.agromarket.selectItem.infrastructure.persistence.entity.SelectItemEntity;
import org.springframework.stereotype.Component;

@Component
public class SelectItemMapper {
    public SelectItemEntity domainToEntity(SelectItem selectItem) {
        return new SelectItemEntity(
                selectItem.getAmountSelect(),
                selectItem.getIdCompany(),
                selectItem.getIdProduct(),
                selectItem.getShippingStatus()
        );
    }

    public ProductItemResponseDto entityToDomain(SelectItemEntity selectItemEntity) {
        return new ProductItemResponseDto(
                selectItemEntity.getId(),
                selectItemEntity.getAmountSelect(),
                selectItemEntity.getDate(),
                selectItemEntity.getIdCompany(),
                selectItemEntity.getIdProduct(),
                selectItemEntity.getShippingStatus()
        );
    }
}