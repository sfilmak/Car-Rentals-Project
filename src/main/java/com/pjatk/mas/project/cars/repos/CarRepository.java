package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.*;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT carTable from Car carTable LEFT JOIN FETCH carTable.carRentals WHERE carTable.carID = ?1")
    Optional<Car> findById(@Param("carID") Long carID);

    Set<Car> findByManufacturer(@Param("manufacturer") String manufacturer);
    Set<Car> findByModel(@Param("model") String model);
    Set<Car> findByColor(@Param("color") String color);
}