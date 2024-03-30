package main.agromarket.farmer.infrastructure.persistence;

import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.farmer.infrastructure.persistence.mapper.FarmerMapper;
import main.agromarket.farmer.infrastructure.persistence.repository.JpaUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void save(Farmer farmer) {
        FarmerEntity farmerEntity = farmerMapper.domainToEntity(farmer);
        this.userRepository.save(farmerEntity);
    }
}