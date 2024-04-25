package main.agromarket.product.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.agromarket.productCategory.infrastructure.persistence.entity.ProductCategoryEntity;

import java.util.UUID;

@Entity
@Table(name = "_product")
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategoryEntity category;

    public ProductEntity(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }
}
