package main.agromarket.Waste.application.findById;

import lombok.RequiredArgsConstructor;
import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.WasteRepositoryPort;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindWasteByIdUseCase {

    private final WasteRepositoryPort wasteRepository;

    public Optional<WasteResponseDto> findById(UUID id){
       return wasteRepository.getById(id);
    }
}
