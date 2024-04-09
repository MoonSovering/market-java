package main.agromarket.farmer.application.findById;

import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindFarmerByIdUseCase {
    private final UserRepositoryPort userRepository;

    public FindFarmerByIdUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<Farmer> findById(String id){
        return this.userRepository.getById(id);
    }
}
