package main.agromarket.Waste.domain.ports.out;

import main.agromarket.Waste.domain.model.Waste;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WasteRepositoryPort {
    Waste save(Waste waste);
    List<Waste> getAll();
    Optional<Waste> getById(UUID id);
}
