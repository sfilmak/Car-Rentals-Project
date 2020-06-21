package com.pjatk.mas.project.cars.repos.crud;

import com.pjatk.mas.project.cars.model.CarRental;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
    @Query("SELECT carTable from Car carTable LEFT JOIN FETCH carTable.carRentals WHERE carTable.carID = ?1")
    Optional<CarRental> findByCarID(Long carID);

    @Query("SELECT customerTable from Customer customerTable LEFT JOIN FETCH customerTable.carRentals WHERE customerTable.id = ?1")
    Optional<CarRental> findCustomerByID(Long customerID);

    Set<CarRental> findCarRentalsByCar(Car car);
    Set<CarRental> findCarRentalsByComments(String comments);
}

