package main.agromarket.company.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private CompanyName name;
    private List<CompanyContact> contact;
    private CompanyAddress address;
    private CompanyEmail email;
    private CompanyPassword password;
    private CompanyStatus status;
}
