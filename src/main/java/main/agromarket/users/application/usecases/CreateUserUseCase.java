package main.agromarket.users.application.usecases;

import main.agromarket.users.application.dto.CreateUserRequest;
import main.agromarket.users.domain.model.User;
import main.agromarket.users.domain.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    private final UserRepositoryPort userRepository;
    public CreateUserUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(CreateUserRequest request){
        User user = new User(
                request.userId(),
                request.userName(),
                request.email(),
                request.password(),
                request.status()
        );
        userRepository.save(user);
    }
}
