package com.pjatk.mas.project.cars.model.person.employees;

import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;
import com.pjatk.mas.project.cars.model.vehicle.Car;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Manager extends Employee {

    //Association with cars
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "car_manager",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Set<Car> cars = new HashSet<>();

    public Manager(){
        super();
    }

    public Manager(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate, double salary, @NotBlank String workEmail,
                      @NotNull EmployeeStatus employeeStatus, LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate){
        super(name, surname, birthdate, salary, workEmail, employeeStatus, hireDate, internshipStartDate, internshipEndDate);
    }

    public void addCar(Car car) {
        cars.add(car);
        car.getManagers().add(this);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        car.getManagers().remove(this);
    }

    public Set<Car> getCars() {
        return new HashSet<>(cars);
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
