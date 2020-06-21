package com.pjatk.mas.project.cars.model;

import com.pjatk.mas.project.cars.model.enums.RentalStatus;
import com.pjatk.mas.project.cars.model.person.Customer;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carRentalID;

    @NotNull
    @Column(columnDefinition = "DATE")
    @FutureOrPresent
    private LocalDate startDate;

    @NotNull
    @Column(columnDefinition = "DATE")
    @FutureOrPresent
    private LocalDate endDate;

    @NotBlank
    private String comments;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    @NotNull(message = "CarRental should have a car!")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @NotNull(message = "CarRental should have a customer!")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public CarRental(){}

    public CarRental(@NotNull LocalDate startDate, @NotNull LocalDate endDate,
                     @NotBlank String comments, @NotNull RentalStatus rentalStatus,
                     @NotNull Car car, @NotNull Customer customer) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setComments(comments);
        this.setRentalStatus(rentalStatus);
        this.setCar(car);
        this.setCustomer(customer);
    }

    public Long getCarRentalID() {
        return carRentalID;
    }

    public void setCarRentalID(Long carRentalID) {
        this.carRentalID = carRentalID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if(this.car != car) {
            if(this.car != null) {
                Car tmp = this.car;
                this.car = null;
                tmp.changeCarRental(this, car);
            }
            this.car = car;
            if(car != null) {
                car.addCarRental(this);
            }
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if(this.customer != customer) {
            if(this.customer != null) {
                Customer tmp = this.customer;
                this.customer = null;
                tmp.changeCustomer(this, customer);
            }
            this.customer = customer;
            if(customer != null) {
                customer.addCustomer(this);
            }
        }
    }
}
