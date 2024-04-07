package main.agromarket.farmer.application.create;

import lombok.AllArgsConstructor;
import main.agromarket.shared.Enum.Status;

import java.util.List;
import java.util.Objects;
@AllArgsConstructor
public class CreateFarmerRequest {

    private String farmerId;
    private String farmerName;
    private String email;
    private String password;
    private String lastName;
    private String address;
    private List<ContactInfo> contact;
    private String type;
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
    public String address() {
        return address;
    }
    public String farmerId() {
        return farmerId;
    }

    public String farmerName() {
        return farmerName;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public String lastName() {
        return lastName;
    }

    public List<ContactInfo> contact() {
        return contact;
    }

    public String type() {
        return type;
    }

    public Status status() {
        return status;
    }
}
