package main.agromarket.Waste.application.create;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.WasteRepositoryPort;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CreateWasteUseCase {
    private final WasteRepositoryPort wasteRepository;

    public CreateWasteUseCase(WasteRepositoryPort wasteRepository) {
        this.wasteRepository = wasteRepository;
    }

    public WasteResponseDto createWaste(CreateWasteRequest request){
        Waste waste = new Waste(
                request.getIdFarmer(),
                request.getIdStatus(),
                request.getIdProduct(),
                request.getShippingStatus()
        );
        return wasteRepository.save(waste);
    }

}
