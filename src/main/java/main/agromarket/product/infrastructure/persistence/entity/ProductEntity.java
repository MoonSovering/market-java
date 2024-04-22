package main.agromarket.product.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String name;
    @Column
    private int stock;
    @Column
    private String idCategory;

    public ProductEntity(String name, int stock, String idCategory) {
        this.name = name;
        this.stock = stock;
        this.idCategory = idCategory;
    }
}
