package main.agromarket.selectItem.domain.ports.out;

import main.agromarket.selectItem.domain.model.SelectItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SelectItemRepositoryPort {
    SelectItem create(SelectItem item);
    List<SelectItem> getAll();
    Optional<SelectItem> getById(UUID id);
}
