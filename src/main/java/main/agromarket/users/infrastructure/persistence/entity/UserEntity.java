package main.agromarket.users.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {
    @Id
    @Column
    private String userId;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String status;
}
