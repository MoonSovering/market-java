package main.agromarket.farmer.application.create;

import main.agromarket.farmer.application.create.CreateFarmerRequest;
import main.agromarket.farmer.domain.model.*;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateFarmerUseCase {
    private final UserRepositoryPort userRepository;
    public CreateFarmerUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }
    public void createFarmer(CreateFarmerRequest request){
        Farmer farmer = new Farmer(
                new FarmerId(request.farmerId()),
                new FarmerName(request.farmerName()),
                new FarmerEmail(request.email()),
                new FarmerPassword(request.password()),
                new FarmerLastName(request.lastName()),
                new FarmerAddress(request.address())
        );
        userRepository.save(farmer);
    }
}
