package main.agromarket.farmer.application.delete;

import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteFarmerUseCase {
    private final UserRepositoryPort userRepository;

    public DeleteFarmerUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteFarmer(UUID id){
        this.userRepository.deleted(id);
    }
}
