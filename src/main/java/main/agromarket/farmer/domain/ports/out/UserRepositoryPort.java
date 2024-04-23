package main.agromarket.farmer.domain.ports.out;

import main.agromarket.farmer.domain.model.Farmer;
import main.agromarket.farmer.domain.ports.out.response.FarmerResponseDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    FarmerResponseDto save(Farmer farmer);
    void deleted(String id);
    Optional<FarmerResponseDto> getById(String id);
    List<FarmerResponseDto> getAll();

}
