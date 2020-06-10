package com.pjatk.mas.project.cars.repos;

import java.util.Optional;
import java.util.Set;

import com.pjatk.mas.project.cars.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    /*Optional<Car> findById(Long id);
    Set<Car> findByManufacturer(String manufacturer);
    Set<Car> findByModel(String model);*/
}

