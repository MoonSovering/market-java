package main.agromarket.product.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
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
    private Float price;
    @Column
    private int stock;
    @ManyToOne()
    @JoinColumn(name = "category_id", unique = false)
    private ProductCategoryEntity category;
    @OneToOne(mappedBy = "product")
    private WasteEntity waste;

    public ProductEntity(String name, float price ,int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}