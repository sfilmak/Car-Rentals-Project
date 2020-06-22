package com.pjatk.mas.project.cars.model.vehicle;

import com.pjatk.mas.project.cars.model.enums.EngineType;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Part of the car
//Composition
@Entity(name = "Engine")
@Table(name = "engine")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long engineID;

    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EngineType type;

    private Float litres;

    private Integer cylinders;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Engine(){}

    Engine(@NotNull Car car, @NotBlank String name, @NotNull EngineType type) {
        this.setCar(car);
        this.setName(name);
        this.setType(type);
    }

    Engine(@NotNull Car car, @NotBlank String name, @NotNull EngineType type, Float litres, Integer cylinders) {
        this(car, name, type);
        this.setLitres(litres);
        this.setCylinders(cylinders);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public Float getLitres() {
        return litres;
    }

    public void setLitres(Float litres) {
        this.litres = litres;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Long getEngineID() {
        return engineID;
    }

    public void setEngineID(Long engineID) {
        this.engineID = engineID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car){
        this.car = car;
    }

}
