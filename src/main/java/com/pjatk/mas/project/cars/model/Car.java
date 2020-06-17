package com.pjatk.mas.project.cars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carID;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private String model;

    @NotBlank
    private String color;

    @NotBlank
    private String carType;

    @NotNull
    private LocalDate dateOfManufacture;

    //Should be bigger than 0
    private float pricePerDay;

    //Optional
    private Float maxSpeed;

    @NotBlank
    private String imageURL;

    public Car(){}

    public Car(@NotBlank String manufacturer, @NotBlank String model, @NotBlank String color, @NotBlank String carType, @NotNull LocalDate dateOfManufacture, float pricePerDay, @NotBlank String imageURL) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setColor(color);
        this.setCarType(carType);
        this.setDateOfManufacture(dateOfManufacture);
        this.setPricePerDay(pricePerDay);
        this.setImageURL(imageURL);
    }

    public Car(@NotBlank String manufacturer, @NotBlank String model, @NotBlank String color, @NotBlank String carType, @NotNull LocalDate dateOfManufacture, float pricePerDay, Float maxSpeed, @NotBlank String imageURL) {
        this(manufacturer, model, color, carType, dateOfManufacture, pricePerDay, imageURL);
        this.setMaxSpeed(maxSpeed);
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carID, car.carID) &&
                Objects.equals(manufacturer, car.manufacturer) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID, manufacturer, model);
    }
}
