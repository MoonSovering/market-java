package main.agromarket.users.application.usecases;

import main.agromarket.users.domain.model.User;
import main.agromarket.users.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCase {
    private final UserRepositoryPort userRepository;
    public CreateUserUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        return this.userRepository.save(user);
    }
}
