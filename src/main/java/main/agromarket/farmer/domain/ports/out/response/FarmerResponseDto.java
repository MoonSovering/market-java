package main.agromarket.farmer.domain.ports.out.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class FarmerResponseDto {
    private UUID farmerId;
    private String farmerName;
    private String email;
    private String password;
    private String lastName;
    private String address;
    private List<ContactAdditionalInfo> contact;
    private List<FarmTypeInfo> type;
    private String status;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ContactAdditionalInfo {
        private String contactType;
        private String contact;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class FarmTypeInfo {
        private String typeFarm;
        private String farm;
    }
}
