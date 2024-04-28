package main.agromarket.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientResponseDto {
    private String Id;
    private String email;
    private String username;
    private String status;
}
