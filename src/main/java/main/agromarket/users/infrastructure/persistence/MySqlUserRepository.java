package main.agromarket.users.infrastructure.persistence;

import main.agromarket.users.domain.model.User;
import main.agromarket.users.domain.ports.out.UserRepositoryPort;
import main.agromarket.users.infrastructure.persistence.entity.UserEntity;
import main.agromarket.users.infrastructure.persistence.mapper.UserMapper;
import main.agromarket.users.infrastructure.persistence.repository.JpaUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MySqlUserRepository implements UserRepositoryPort {
    private final JpaUserRepository userRepository;
    private final UserMapper userMapper;

    public MySqlUserRepository(JpaUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    @Transactional
    public void save(User user) {
        UserEntity userEntity = userMapper.domainToEntity(user);
        this.userRepository.save(userEntity);
    }
}