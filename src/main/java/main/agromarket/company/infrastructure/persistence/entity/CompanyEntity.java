package main.agromarket.company.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyEntity {
    @Id
    @Column
    private String companyId;
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
}