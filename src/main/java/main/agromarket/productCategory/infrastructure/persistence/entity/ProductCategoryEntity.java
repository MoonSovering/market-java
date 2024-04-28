package main.agromarket.productCategory.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import main.agromarket.product.infrastructure.persistence.entity.ProductEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "_product-category")
@Getter
@Setter
@NoArgsConstructor
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column
    private String name;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> product;

    public ProductCategoryEntity(String name) {
        this.name = name;
    }
}
