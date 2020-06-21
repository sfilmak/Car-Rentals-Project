package com.pjatk.mas.project.cars.model.vehicle;

import com.pjatk.mas.project.cars.model.CarRental;
import com.pjatk.mas.project.cars.model.person.employees.Manager;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Car")
@Table(name = "car")
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
    @Column(columnDefinition = "DATE")
    @PastOrPresent
    private LocalDate dateOfManufacture;

    //Should be bigger than 0
    private float pricePerDay;

    //Optional
    private Float maxSpeed;

    @NotBlank
    private String imageURL;

    private static Set<Engine> allParts = new HashSet<>();

    //Association with a CarRental
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    private final Set<CarRental> carRentals = new HashSet<>();

    //Association with a Technical Inspection
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    private final Set<TechnicalInspection> technicalInspectionsSet = new HashSet<>();

    //Association with managers
    @ManyToMany(mappedBy = "cars")
    private Set<Manager> managers = new HashSet<>();

    public Car() { }

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

    public static void setPricePerDay(Long carID, float price) {
        //TODO
    }

    public static void setPricePerDay(Long carID, float price, float tax) {
        //TODO
    }

    public void addCarRental(CarRental carRental) {
        if (!carRentals.contains(carRental)) {
            carRentals.add(carRental);
            carRental.setCar(this);
        }
    }

    public void changeCarRental(CarRental carRental, Car newCar) {
        if (carRentals.contains(carRental)) {
            carRentals.remove(carRental);
            carRental.setCar(newCar);
        }
    }

    public void addTechnicalInspection(TechnicalInspection technicalInspection) {
        if (!technicalInspectionsSet.contains(technicalInspection)) {
            technicalInspectionsSet.add(technicalInspection);
            technicalInspection.setCar(this);
        }
    }

    public void changeTechnicalInspection(TechnicalInspection technicalInspection, Car newCar) {
        if (technicalInspectionsSet.contains(technicalInspection)) {
            technicalInspectionsSet.remove(technicalInspection);
            technicalInspection.setCar(newCar);
        }
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

    public void addManager(Manager manager) {
        managers.add(manager);
        manager.getCars().add(this);
    }

    public void removeManager(Manager manager) {
        managers.remove(manager);
        manager.getCars().remove(this);
    }

    public Set<CarRental> getCarRentals() {
        return carRentals;
    }

    public Set<TechnicalInspection> getTechnicalInspectionsSet() {
        return technicalInspectionsSet;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

    public void addEngine(Engine engine) {
        if (allParts.contains(engine)) {
            throw new IllegalArgumentException("This part is added to some other car");
        }
        allParts.add(engine);
    }

    public void removeEngine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        if (!allParts.contains(engine)) {
            throw new IllegalArgumentException("Cannot find this part among all parts");
        }
        allParts.remove(engine);
        Engine.destroyPart(engine);
    }
}
