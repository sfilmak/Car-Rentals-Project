package com.pjatk.mas.project.cars.repos.rest;

import com.pjatk.mas.project.cars.model.CarRental;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import com.pjatk.mas.project.cars.repos.crud.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CarRentalResource {

    @Autowired
    private CarRentalRepository carRentalRepository;

    @GetMapping("/students")
    public List<CarRental> retrieveAllStudents() {
        return carRentalRepository.findAll();
    }

    @RequestMapping("/allCarRentalsByCarName")
    public Set<CarRental> retrieveCarRentalsByCarName(@RequestParam(value = "comments") String comments) {
        return carRentalRepository.findCarRentalsByComments(comments);
    }

    @GetMapping("/allCarRentals")
    public Set<CarRental> retrieveAllRentalsByCar(Car car) {
         return carRentalRepository.findCarRentalsByCar(car);
    }

    @GetMapping("/carRental/{id}")
    public Optional<CarRental> retrieveCarRental(@PathVariable long id) {
        return carRentalRepository.findById(id);
    }

}
