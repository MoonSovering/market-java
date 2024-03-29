package main.agromarket.users.domain.ports.in;

import main.agromarket.users.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
