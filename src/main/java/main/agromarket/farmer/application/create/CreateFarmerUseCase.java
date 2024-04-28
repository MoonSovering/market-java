package main.agromarket.farmer.application.create;

import main.agromarket.farmer.domain.model.*;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import main.agromarket.farmer.domain.ports.out.response.FarmerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateFarmerUseCase {
    private final UserRepositoryPort userRepository;
    public CreateFarmerUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }
    public FarmerResponseDto createFarmer(CreateFarmerRequest request){
        List<FarmerContact> companyContacts = request.contact().stream()
                .map(contactDetail -> new FarmerContact(
                        contactDetail.contactType(),
                        contactDetail.contact()
                )).toList();
        List<FarmType> farmTypes = request.type().stream()
                .map( farmType -> new FarmType(
                        farmType.typeFarm(),
                        farmType.farm()
                ) ).toList();
        Farmer farmer = new Farmer(
                new FarmerName(request.farmerName()),
                new FarmerEmail(request.email()),
                new FarmerPassword(request.password()),
                new FarmerLastName(request.lastName()),
                new FarmerAddress(request.address()),
                companyContacts,
                farmTypes,
                new FarmerStatus(request.status())
        );
        return userRepository.save(farmer);
    }
}