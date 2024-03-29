package main.agromarket.users.infrastructure.persistence.mapper;

import main.agromarket.users.domain.model.User;
import main.agromarket.users.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity domainToEntity(User user) {
        return new UserEntity(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus()
        );
    }
}
