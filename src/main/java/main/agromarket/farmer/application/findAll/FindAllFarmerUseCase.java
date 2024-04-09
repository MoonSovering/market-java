package main.agromarket.farmer.application.findAll;

import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllFarmerUseCase {
    private final UserRepositoryPort userRepository;

    public FindAllFarmerUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public List<Farmer> findAll(){
        return this.userRepository.getAll();
    }
}
