package main.agromarket.farmer.application.create;

import main.agromarket.shared.Enum.Status;

import java.util.Objects;

public class CreateFarmerRequest {

    private String farmerId;
    private String farmerName;
    private String email;
    private String password;
    private String lastName;
    private String address;
    private String contact;
    private String type;
    private Status status;

    public CreateFarmerRequest(String farmerId, String farmerName, String email, String password, String lastName,
                               String address, String contact, String type, Status status) {
        this.farmerId = farmerId;
        this.farmerName = farmerName;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.type = type;
        this.status = status;
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

    public String contact() {
        return contact;
    }

    public String type() {
        return type;
    }

    public Status status() {
        return status;
    }
}
