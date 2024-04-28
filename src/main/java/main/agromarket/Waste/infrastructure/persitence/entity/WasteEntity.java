package main.agromarket.Waste.infrastructure.persitence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.agromarket.farmer.infrastructure.persistence.entity.FarmerEntity;
import main.agromarket.product.infrastructure.persistence.entity.ProductEntity;
import main.agromarket.shared.Enum.ShippingStatus;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "_waste")
@NoArgsConstructor
@Getter
@Setter
public class WasteEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID wasteId;
    @ManyToOne
    @JoinColumn(name = "farmer_uuid")
    private FarmerEntity farmer;
    @Column
    private String idProduct;
    @Column
    LocalDate publishedDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    public WasteEntity(String idProduct, ShippingStatus shippingStatus) {
        this.idProduct = idProduct;
        this.shippingStatus = shippingStatus;
    }
}
