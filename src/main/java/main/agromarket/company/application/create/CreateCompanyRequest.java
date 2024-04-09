package main.agromarket.company.application.create;

import lombok.AllArgsConstructor;
import main.agromarket.shared.Enum.Status;

import java.util.List;

@AllArgsConstructor
public class CreateCompanyRequest {
    private String companyId;
    private String name;
    private List<ContactInfo> contact;
    private String address;
    private String email;
    private String password;
    private Status status;

    @AllArgsConstructor
    public static class ContactInfo {
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

    public List<ContactInfo> contact() {
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

    public Status status() {
        return status;
    }
}
