package main.agromarket.auth.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FarmerResponseDto {
    private String Id;
    private String email;
    private String username;
    private String status;
    private List<WasteResponse> product;


    @Getter
    @Setter
    @AllArgsConstructor
    public static class WasteResponse {
        private LocalDate publishedDate;
        private String shippingStatus;
        private String name;
        private String category;
        private float price;
        private Integer amount;
    }
}
