package com.pjatk.mas.project.cars.repos.crud;

import com.pjatk.mas.project.cars.model.vehicle.TechnicalInspection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TechnicalInspectionRepo extends CrudRepository<TechnicalInspection, Long> {
    @Query("SELECT carTable from Car carTable LEFT JOIN FETCH carTable.carRentals WHERE carTable.carID = ?1")
    Optional<TechnicalInspection> findByCarID(Long carID);
}
