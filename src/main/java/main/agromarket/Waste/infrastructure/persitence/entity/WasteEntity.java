package main.agromarket.Waste.infrastructure.persitence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "waste")
@NoArgsConstructor
@Getter
@Setter
public class WasteEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID wasteId;
    @Column
    private String idFarmer;
    @Column
    private String idStatus;
    @Column
    private String idProduct;
    @Column
    LocalDate publishedDate = LocalDate.now();
}
