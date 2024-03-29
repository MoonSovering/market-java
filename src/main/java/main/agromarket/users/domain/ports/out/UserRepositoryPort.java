package main.agromarket.users.domain.ports.out;

import main.agromarket.users.domain.model.User;

public interface UserRepositoryPort {
    void save(User user);
}
