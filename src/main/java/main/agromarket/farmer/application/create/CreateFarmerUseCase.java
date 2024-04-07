package main.agromarket.farmer.application.create;

import main.agromarket.company.domain.model.CompanyContact;
import main.agromarket.farmer.application.create.CreateFarmerRequest;
import main.agromarket.farmer.domain.model.*;
import main.agromarket.farmer.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateFarmerUseCase {
    private final UserRepositoryPort userRepository;
    public CreateFarmerUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }
    public void createFarmer(CreateFarmerRequest request){
        List<FarmerContact> companyContacts = request.contact().stream()
                .map(contactDetail -> new FarmerContact(
                        contactDetail.contactType(),
                        contactDetail.contact()
                )).toList();
        Farmer farmer = new Farmer(
                new FarmerId(request.farmerId()),
                new FarmerName(request.farmerName()),
                new FarmerEmail(request.email()),
                new FarmerPassword(request.password()),
                new FarmerLastName(request.lastName()),
                new FarmerAddress(request.address()),
                companyContacts,
                new FarmType(request.type()),
                new FarmerStatus(request.status())
        );
        userRepository.save(farmer);
    }
}