package main.agromarket.farmer.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FarmerEntity {
    @Id
    @Column
    private String farmerId;
    @Column
    private String farmerName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String contact;
    @Column
    private String type;
    @Column
    private String status;
}
