package com.pjatk.mas.project.cars.repos.crud;

import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    /*Optional<Car> findById(Long id);
    Set<Car> findByManufacturer(String manufacturer);
    Set<Car> findByModel(String model);*/
}

