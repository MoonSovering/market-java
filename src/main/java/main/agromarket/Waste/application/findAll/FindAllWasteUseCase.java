package main.agromarket.Waste.application.findAll;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.WasteRepositoryPort;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllWasteUseCase {
    private final WasteRepositoryPort wasteRepository;

    public List<WasteResponseDto> findAllWaste(){
        return wasteRepository.getAll();
    }
}
