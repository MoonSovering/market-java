package main.agromarket.users.application.usecases;

import main.agromarket.users.application.dto.CreateUserRequest;
import main.agromarket.users.domain.model.*;
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
                new UserId(request.userId()),
                new UserName(request.userName()),
                new UserEmail(request.email()),
                new UserPassword(request.password()),
                new UserStatus(request.status())
        );
        userRepository.save(user);
    }
}
