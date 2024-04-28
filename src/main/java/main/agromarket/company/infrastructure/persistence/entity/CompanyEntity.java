package main.agromarket.company.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "_companies")
@NoArgsConstructor
@Getter
@Setter
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyId;
    @Column
    private String name;
    @ElementCollection
    private List<ContactAdditionalInfo> contact;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String status;

    public CompanyEntity(String name, List<ContactAdditionalInfo> contact, String address, String email, String password, String status) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.password = password;
        this.status = status;
    }
}