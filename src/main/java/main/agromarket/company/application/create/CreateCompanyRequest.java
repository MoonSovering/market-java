package main.agromarket.company.application.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import main.agromarket.company.domain.model.*;

import java.util.List;

@AllArgsConstructor
public class CreateCompanyRequest {
    private String companyId;
    private String name;
    private List<ContactDetail> contact;
    private String address;
    private String email;
    private String password;
    private String status;

    @AllArgsConstructor
    public static class ContactDetail{
        private String contactType;
        private String contact;


        public String contactType() {
            return contactType;
        }
        public String contact() {
            return contact;
        }
    }

    public String companyId() {
        return companyId;
    }

    public String name() {
        return name;
    }

    public List<ContactDetail> contact() {
        return contact;
    }

    public String address() {
        return address;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public String status() {
        return status;
    }
}
