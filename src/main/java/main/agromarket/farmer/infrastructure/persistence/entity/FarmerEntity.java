package main.agromarket.farmer.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "farmer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @ElementCollection
    private List<ContactAdditionalInfo> contact;
    @ElementCollection
    private List<FarmTypeInfo> type;
    @Column
    private String status;
}