package main.agromarket.Waste.infrastructure.persitence;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.WasteRepositoryPort;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import main.agromarket.Waste.infrastructure.persitence.mapper.WasteMapper;
import main.agromarket.Waste.infrastructure.persitence.repository.JpaWasteRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MySqlWasteRepository implements WasteRepositoryPort {
    private final JpaWasteRepository repository;
    private final WasteMapper mapper;

    public MySqlWasteRepository(JpaWasteRepository repository, WasteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Waste save(Waste waste) {
        WasteEntity wasteEntity = mapper.domainToEntity(waste);
        WasteEntity savedEntity = repository.save(wasteEntity);
        return mapper.entityToDomain(savedEntity);
    }

    @Override
    public List<Waste> getAll() {
        List<WasteEntity> wastes = repository.findAll();
        if(wastes.isEmpty()){
            throw new GeneralException("Waste's cannot be found.", HttpStatus.BAD_REQUEST);
        }
        return wastes.stream()
                .map(mapper::entityToDomain).toList();
    }

    @Override
    public Optional<Waste> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::entityToDomain);
    }
}
