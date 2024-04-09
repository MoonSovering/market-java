package main.agromarket.farmer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
