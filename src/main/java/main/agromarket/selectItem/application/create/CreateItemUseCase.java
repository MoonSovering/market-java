package main.agromarket.selectItem.application.create;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.SelectItemRepositoryPort;
import main.agromarket.selectItem.domain.ports.out.response.ProductItemResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CreateItemUseCase {
    private final SelectItemRepositoryPort repository;

    public CreateItemUseCase(SelectItemRepositoryPort repository) {
        this.repository = repository;
    }

    public ProductItemResponseDto create(CreateItemRequest item){
        return repository.create(new SelectItem(
                item.getAmountSelect(),
                item.getIdCompany(),
                item.getIdStatus(),
                item.getIdProduct(),
                item.getShippingStatus()
        ));
    }
}
