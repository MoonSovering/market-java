package main.agromarket.productCategory.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "_product-category")
@Getter
@Setter
@NoArgsConstructor
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String name;

    public ProductCategoryEntity(String name) {
        this.name = name;
    }
}
