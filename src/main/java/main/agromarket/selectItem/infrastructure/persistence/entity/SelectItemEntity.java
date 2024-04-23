package main.agromarket.selectItem.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.agromarket.shared.Enum.ShippingStatus;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "_select-products")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SelectItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private int amountSelect;
    @Column
    private LocalDate date = LocalDate.now();
    @Column
    private String idCompany;
    @Column
    private String idStatus;
    @Column
    private String idProduct;
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus;

    public SelectItemEntity(int amountSelect, String idCompany, String idStatus, String idProduct, ShippingStatus shippingStatus) {
        this.amountSelect = amountSelect;
        this.idCompany = idCompany;
        this.idStatus = idStatus;
        this.idProduct = idProduct;
        this.shippingStatus = shippingStatus;
    }
}
