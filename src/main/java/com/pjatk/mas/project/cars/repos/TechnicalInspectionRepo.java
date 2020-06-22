package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.vehicle.TechnicalInspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TechnicalInspectionRepo extends JpaRepository<TechnicalInspection, Long> {
    @Query("SELECT carTable from Car carTable LEFT JOIN FETCH carTable.carRentals WHERE carTable.carID = ?1")
    Optional<TechnicalInspection> findByCarID(Long carID);
}
