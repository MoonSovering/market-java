package main.agromarket.farmer.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "_farmer")
@NoArgsConstructor
@Getter
@Setter
public class FarmerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID farmerId;
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
    @ElementCollection
    private List<ContactAdditionalInfoEntity> contact;
    @ElementCollection
    private List<FarmTypeInformationEntity> type;
    @Column
    private String status;

    public FarmerEntity(String farmerName, String email, String password, String lastName, String address, List<ContactAdditionalInfoEntity> contact, List<FarmTypeInformationEntity> type, String status) {
        this.farmerName = farmerName;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.type = type;
        this.status = status;
    }
}