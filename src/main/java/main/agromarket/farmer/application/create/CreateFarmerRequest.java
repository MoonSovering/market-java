package main.agromarket.farmer.application.create;

import java.util.Objects;

public class CreateFarmerRequest {

    private String farmerId;
    private String farmerName;
    private String email;
    private String password;
    private String lastName;
    private String address;

    public CreateFarmerRequest(String farmerId, String farmerName, String email, String password, String lastName, String address) {
        this.farmerId = farmerId;
        this.farmerName = farmerName;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateFarmerRequest that = (CreateFarmerRequest) o;

        if (!Objects.equals(farmerId, that.farmerId)) return false;
        if (!Objects.equals(farmerName, that.farmerName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = farmerId != null ? farmerId.hashCode() : 0;
        result = 31 * result + (farmerName != null ? farmerName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
