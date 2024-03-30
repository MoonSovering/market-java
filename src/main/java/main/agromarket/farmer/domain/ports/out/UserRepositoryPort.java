package main.agromarket.farmer.domain.ports.out;

import main.agromarket.farmer.domain.model.Farmer;

public interface UserRepositoryPort {
    void save(Farmer farmer);
}
