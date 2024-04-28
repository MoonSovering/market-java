package main.agromarket.Waste.infrastructure.persitence;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.WasteRepositoryPort;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import main.agromarket.Waste.infrastructure.persitence.mapper.WasteMapper;
import main.agromarket.Waste.infrastructure.persitence.repository.JpaWasteRepository;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.farmer.infrastructure.persistence.repository.JpaUserRepository;
import main.agromarket.product.infrastructure.persistence.entity.ProductEntity;
import main.agromarket.product.infrastructure.persistence.repository.ProductJpaRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MySqlWasteRepository implements WasteRepositoryPort {
    private final JpaWasteRepository repository;
    private final JpaUserRepository farmerRepository;
    private final ProductJpaRepository productRepository;
    private final WasteMapper mapper;

    public MySqlWasteRepository(JpaWasteRepository repository, JpaUserRepository farmerRepository, ProductJpaRepository productRepository, WasteMapper mapper) {
        this.repository = repository;
        this.farmerRepository = farmerRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public WasteResponseDto save(Waste waste) {
        WasteEntity wasteEntity = mapper.domainToEntity(waste);
        Optional<FarmerEntity> farmer = farmerRepository.findById(UUID.fromString(waste.getIdFarmer()));
        Optional<ProductEntity> product = productRepository.findById(UUID.fromString(waste.getIdProduct()));
        product.ifPresent(wasteEntity::setProduct);
        farmer.ifPresent(wasteEntity::setFarmer);
        WasteEntity savedEntity = repository.save(wasteEntity);
        return mapper.entityToDomain(savedEntity);
    }

    @Override
    public List<WasteResponseDto> getAll() {
        List<WasteEntity> wastes = repository.findAll();
        if(wastes.isEmpty()){
            throw new GeneralException("Waste's cannot be found.", HttpStatus.BAD_REQUEST);
        }
        return wastes.stream()
                .map(mapper::entityToDomain).toList();
    }

    @Override
    public Optional<WasteResponseDto> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::entityToDomain);
    }
}
