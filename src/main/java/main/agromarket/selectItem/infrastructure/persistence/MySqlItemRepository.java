package main.agromarket.selectItem.infrastructure.persistence;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.SelectItemRepositoryPort;
import main.agromarket.selectItem.infrastructure.persistence.entity.SelectItemEntity;
import main.agromarket.selectItem.infrastructure.persistence.mapper.SelectItemMapper;
import main.agromarket.selectItem.infrastructure.persistence.repository.SelectItemJpaRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MySqlItemRepository implements SelectItemRepositoryPort {
    private final SelectItemJpaRepository repository;
    private final SelectItemMapper mapper;

    public MySqlItemRepository(SelectItemJpaRepository repository, SelectItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public SelectItem create(SelectItem item) {
        SelectItemEntity itemEntity = mapper.domainToEntity(item);
        SelectItemEntity savedEntity = repository.save(itemEntity);
        return mapper.entityToDomain(savedEntity);
    }

    @Override
    public List<SelectItem> getAll() {
        List<SelectItemEntity> items = repository.findAll();
        if(items.isEmpty()){
            throw new GeneralException("No Select items found in the list.", HttpStatus.BAD_REQUEST);
        }
        return items.stream()
                .map(mapper::entityToDomain).toList();
    }

    @Override
    public Optional<SelectItem> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::entityToDomain);
    }
}
