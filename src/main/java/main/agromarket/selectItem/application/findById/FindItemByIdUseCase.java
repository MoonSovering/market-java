package main.agromarket.selectItem.application.findById;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.SelectItemRepositoryPort;
import main.agromarket.selectItem.domain.ports.out.response.ProductItemResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindItemByIdUseCase {
    private final SelectItemRepositoryPort repository;

    public FindItemByIdUseCase(SelectItemRepositoryPort repository) {
        this.repository = repository;
    }

    public Optional<ProductItemResponseDto> findById(UUID id){
        return repository.getById(id);
    }
}
