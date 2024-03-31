package main.agromarket.farmer.domain.ports.out;

import main.agromarket.farmer.domain.model.Farmer;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    void save(Farmer farmer);
    void deleted(String id);
    Optional<Farmer> getById(String id);
    List<Farmer> getAll();

}
