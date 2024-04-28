package main.agromarket.company.domain.ports.response;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CompanyResponseDto {
    private UUID companyId;
    private String name;
    private List<ContactAdditionalInfo> contact;
    private String address;
    private String email;
    private String password;
    private String status;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ContactAdditionalInfo {
        private String contactType;
        private String contact;
    }
}
