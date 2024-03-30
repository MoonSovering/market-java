package main.agromarket.farmer.domain.model;


public final class Farmer {
    private FarmerId user;
    private FarmerName name;
    private FarmerEmail email;
    private FarmerPassword password;
    private FarmerLastName lastName;
    private FarmerAddress address;

    public Farmer(FarmerId user, FarmerName name, FarmerEmail email, FarmerPassword password, FarmerLastName lastName, FarmerAddress address) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.address = address;
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


}
