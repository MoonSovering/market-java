package main.agromarket.farmer.application.create;

import lombok.AllArgsConstructor;
import main.agromarket.shared.Enum.Status;

import java.util.List;
@AllArgsConstructor
public class CreateFarmerRequest {
    private String farmerName;
    private String email;
    private String password;
    private String lastName;
    private String address;
    private List<ContactInfo> contact;
    private List<FarmType> type;
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

    @AllArgsConstructor
    public static class FarmType{
        private String typeFarm;
        private String farm;

        public String typeFarm() {
            return typeFarm;
        }

        public String farm() {
            return farm;
        }
    }

    public String address() {
        return address;
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
    public List<FarmType> type() {
        return type;
    }

    public Status status() {
        return status;
    }
}
