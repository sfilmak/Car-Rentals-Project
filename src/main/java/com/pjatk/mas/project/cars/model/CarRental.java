package com.pjatk.mas.project.cars.model;

import com.pjatk.mas.project.cars.model.enums.RentalStatus;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carID;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;

    @NotBlank
    private String comments;

    @NotNull
    private RentalStatus rentalStatus;

    public CarRental(){}

    public CarRental(@NotNull LocalDate startDate, @NotNull LocalDate endDate, @NotBlank String comments, @NotNull RentalStatus rentalStatus) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setComments(comments);
        this.setRentalStatus(rentalStatus);
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
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
}
