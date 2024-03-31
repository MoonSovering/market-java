package main.agromarket.farmer.domain.model;

import java.util.Objects;

public final class Farmer {
    private FarmerId user;
    private FarmerName name;
    private FarmerEmail email;
    private FarmerPassword password;
    private FarmerLastName lastName;
    private FarmerAddress address;
    private FarmerContact contact;
    private FarmType type;
    private FarmerStatus status;

    public Farmer(FarmerId user, FarmerName name, FarmerEmail email, FarmerPassword password, FarmerLastName lastName,
                  FarmerAddress address, FarmerContact contact, FarmType type, FarmerStatus status) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.type = type;
        this.status = status;
    }
    public FarmerStatus getStatus() {
        return status;
    }

    public FarmerContact getContact() {
        return contact;
    }

    public FarmType getType() {
        return type;
    }

    public FarmerAddress getAddress() {
        return address;
    }

    public FarmerId getUserId() {
        return user;
    }

    public FarmerName getUserName() {
        return name;
    }

    public FarmerEmail getEmail() {
        return email;
    }
    public FarmerPassword getPassword() {
        return password;
    }

    public FarmerLastName getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Farmer farmer = (Farmer) o;

        if (!Objects.equals(user, farmer.user)) return false;
        if (!Objects.equals(name, farmer.name)) return false;
        if (!Objects.equals(email, farmer.email)) return false;
        if (!Objects.equals(password, farmer.password)) return false;
        if (!Objects.equals(lastName, farmer.lastName)) return false;
        if (!Objects.equals(address, farmer.address)) return false;
        if (!Objects.equals(contact, farmer.contact)) return false;
        if (!Objects.equals(type, farmer.type)) return false;
        return Objects.equals(status, farmer.status);
    }
    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
