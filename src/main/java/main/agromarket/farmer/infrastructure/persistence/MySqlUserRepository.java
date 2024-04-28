package main.agromarket.farmer.infrastructure.persistence;

import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import main.agromarket.farmer.domain.ports.out.response.FarmerResponseDto;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.farmer.infrastructure.persistence.mapper.FarmerMapper;
import main.agromarket.farmer.infrastructure.persistence.repository.JpaUserRepository;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MySqlUserRepository implements UserRepositoryPort {
    private final JpaUserRepository userRepository;
    private final FarmerMapper farmerMapper;

    public MySqlUserRepository(JpaUserRepository userRepository, FarmerMapper farmerMapper) {
        this.userRepository = userRepository;
        this.farmerMapper = farmerMapper;
    }
    @Override
    @Transactional
    public FarmerResponseDto save(Farmer farmer) {
        FarmerEntity farmerEntity = farmerMapper.domainToEntity(farmer);
        FarmerEntity result = userRepository.save(farmerEntity);
        return farmerMapper.entityToDomain(result);
    }

    @Override
    public void deleted(UUID id) {
        Optional<FarmerEntity> farmer = this.userRepository.findById(id);
        if (farmer.isEmpty()){
            throw new GeneralException("Farmer cannot be found.", HttpStatus.BAD_REQUEST);
        }
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<FarmerResponseDto> getById(UUID id) {

        Optional<FarmerResponseDto> farmer = this.userRepository.findById(id)
                .map(farmerMapper::entityToDomain);
        if(farmer.isEmpty()){
            throw new GeneralException("Farmer cannot be found.", HttpStatus.BAD_REQUEST);
        }
        return farmer;
    }

    @Override
    public List<FarmerResponseDto> getAll() {
        List<FarmerEntity> farmers =  this.userRepository.findAll();
        if (farmers.isEmpty()){
           throw new GeneralException("No farmers found in the farmer list.", HttpStatus.BAD_REQUEST);
        }
        return farmers.stream()
                .map(farmerMapper::entityToDomain)
                .toList();
    }
}