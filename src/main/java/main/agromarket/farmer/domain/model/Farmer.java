package main.agromarket.farmer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Farmer {
    private FarmerName name;
    private FarmerEmail email;
    private FarmerPassword password;
    private FarmerLastName lastName;
    private FarmerAddress address;
    private List<FarmerContact> contact;
    private List<FarmType> type;
    private FarmerStatus status;
}