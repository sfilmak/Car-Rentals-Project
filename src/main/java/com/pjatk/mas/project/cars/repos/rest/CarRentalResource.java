package com.pjatk.mas.project.cars.repos.rest;

import com.pjatk.mas.project.cars.model.CarRental;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "carRentalsList", path = "carRentalsList")
public interface CarRentalResource extends PagingAndSortingRepository<CarRental, Long> {
    Optional<CarRental> findByCarRentalID(@Param("rentalID") Long carRentalID);
    Set<CarRental> findCarRentalsByCar(Car car);
    Set<CarRental> findByComments(@Param("comment") String comment);
}