package main.agromarket.selectItem.infrastructure.persistence.mapper;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.infrastructure.persistence.entity.SelectItemEntity;
import org.springframework.stereotype.Component;

@Component
public class SelectItemMapper {
    public SelectItemEntity domainToEntity(SelectItem selectItem) {
        return new SelectItemEntity(
                selectItem.getAmountSelect(),
                selectItem.getIdCompany(),
                selectItem.getIdStatus(),
                selectItem.getIdProduct(),
                selectItem.getShippingStatus()
        );
    }

    public SelectItem entityToDomain(SelectItemEntity selectItemEntity) {
        return new SelectItem(
                selectItemEntity.getAmountSelect(),
                selectItemEntity.getIdCompany(),
                selectItemEntity.getIdStatus(),
                selectItemEntity.getIdProduct(),
                selectItemEntity.getShippingStatus()
        );
    }
}