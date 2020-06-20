package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.CarRental;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CarRentalRepository extends CrudRepository<CarRental, Long> {
    @Query("SELECT carTable from Car carTable LEFT JOIN FETCH carTable.carRentals WHERE carTable.carID = ?1")
    Optional<CarRental> findByCarID(Long carID);
}

