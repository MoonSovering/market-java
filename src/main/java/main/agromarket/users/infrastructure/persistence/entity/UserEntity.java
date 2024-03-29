package main.agromarket.users.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {
    @Id
    @Column
    private Long userId;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Long status;
}
