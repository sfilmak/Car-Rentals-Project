package com.pjatk.mas.project.cars.repos.rest;

import com.pjatk.mas.project.cars.model.vehicle.Car;
import com.pjatk.mas.project.cars.repos.crud.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CarResource {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars_example")
    public List<Car> retrieveAllStudents() {
        Iterable<Car> source = carRepository.findAll();
        List<Car> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

}
