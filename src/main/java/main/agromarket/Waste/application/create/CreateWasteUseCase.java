package main.agromarket.Waste.application.create;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.WasteRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateWasteUseCase {
    private final WasteRepositoryPort wasteRepository;

    public CreateWasteUseCase(WasteRepositoryPort wasteRepository) {
        this.wasteRepository = wasteRepository;
    }

    public Waste createWaste(CreateWasteRequest request){
        Waste waste = new Waste(
                request.getIdFarmer(),
                request.getIdStatus(),
                request.getIdProduct()
        );
        return wasteRepository.save(waste);
    }

}
