package com.pjatk.mas.project.cars.model;

import com.pjatk.mas.project.cars.model.enums.EngineType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
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

    public Engine(){}

    public Engine(@NotBlank String name, @NotNull EngineType type) {
        this.setName(name);
        this.setType(type);
    }

    public Engine(@NotBlank String name, @NotNull EngineType type, Float litres, Integer cylinders) {
        this(name, type);
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
}
