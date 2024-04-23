package main.agromarket.Waste.infrastructure.persitence.repository;

import main.agromarket.Waste.infrastructure.persitence.entity.WasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaWasteRepository extends JpaRepository<WasteEntity, UUID> {
}
