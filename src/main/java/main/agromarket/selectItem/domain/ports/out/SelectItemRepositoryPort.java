package main.agromarket.selectItem.domain.ports.out;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.response.ProductItemResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SelectItemRepositoryPort {
    ProductItemResponseDto create(SelectItem item);
    List<ProductItemResponseDto> getAll();
    Optional<ProductItemResponseDto> getById(UUID id);
}
