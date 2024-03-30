package main.agromarket.users.infrastructure.persistence.mapper;

import main.agromarket.users.domain.model.User;
import main.agromarket.users.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity domainToEntity(User user) {
        return new UserEntity(
                user.getUserId().value(),
                user.getUserName().value(),
                user.getEmail().value(),
                user.getPassword().value(),
                user.getStatus().value()
        );
    }
}
