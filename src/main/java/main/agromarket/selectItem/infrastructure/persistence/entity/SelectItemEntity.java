package main.agromarket.selectItem.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "select-products")
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

    public SelectItemEntity(int amountSelect, String idCompany, String idStatus, String idProduct) {
        this.amountSelect = amountSelect;
        this.idCompany = idCompany;
        this.idStatus = idStatus;
        this.idProduct = idProduct;
    }
}
