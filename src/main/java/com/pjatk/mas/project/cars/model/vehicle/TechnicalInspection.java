package com.pjatk.mas.project.cars.model.vehicle;

import com.pjatk.mas.project.cars.model.enums.InspectionType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class TechnicalInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long technicalInspectionID;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    private boolean arePartsReplaced;

    private double carMileage;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InspectionType type;

    @NotNull(message = "Technical inspection should have a car!")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public TechnicalInspection(){}

    public TechnicalInspection(@NotNull LocalDate date, boolean arePartsReplaced, double carMileage, InspectionType type, @NotNull Car car) {
        this.setDate(date);
        this.setArePartsReplaced(arePartsReplaced);
        this.setCarMileage(carMileage);
        this.setType(type);
        this.setCar(car);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isArePartsReplaced() {
        return arePartsReplaced;
    }

    public void setArePartsReplaced(boolean arePartsReplaced) {
        this.arePartsReplaced = arePartsReplaced;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    public InspectionType getType() {
        return type;
    }

    public void setType(InspectionType type) {
        this.type = type;
    }

    public Long getTechnicalInspectionID() {
        return technicalInspectionID;
    }

    public void setTechnicalInspectionID(Long technicalInspectionID) {
        this.technicalInspectionID = technicalInspectionID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if(this.car != car) {
            if(this.car != null) {
                Car tmp = this.car;
                this.car = null;
                tmp.removeTechnicalInspection(this, car);
            }
            this.car = car;
            if(car != null) {
                car.addTechnicalInspection(this);
            }
        }
    }
}
