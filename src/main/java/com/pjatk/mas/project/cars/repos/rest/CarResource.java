package com.pjatk.mas.project.cars.repos.rest;

import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.*;

@RepositoryRestResource(collectionResourceRel = "carsList", path = "carsList")
public interface CarResource extends PagingAndSortingRepository<Car, Long> {
    @Query("SELECT carTable from Car carTable LEFT JOIN FETCH carTable.carRentals WHERE carTable.carID = ?1")
    Optional<Car> findById(@Param("carID") Long carID);
}