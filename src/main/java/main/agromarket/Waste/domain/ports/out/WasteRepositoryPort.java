package main.agromarket.Waste.domain.ports.out;

import main.agromarket.Waste.domain.model.Waste;
import main.agromarket.Waste.domain.ports.out.response.WasteResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WasteRepositoryPort {
    WasteResponseDto save(Waste waste);
    List<WasteResponseDto> getAll();
    Optional<WasteResponseDto> getById(UUID id);
}
