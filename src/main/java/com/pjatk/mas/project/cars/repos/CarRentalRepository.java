package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.CarRental;
import java.util.Optional;
import java.util.Set;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "carRentals")
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    Optional<CarRental> findByCarRentalID(@Param("rentalID") Long carRentalID);
    Set<CarRental> findCarRentalsByCar(Car car);
    Set<CarRental> findByComments(@Param("comment") String comment);
}