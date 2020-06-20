package com.pjatk.mas.project.cars.model.person;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate birthdate;

    public Person(){}

    public Person(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthdate(birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge(){
        return Period.between(getBirthdate(), LocalDate.now()).getYears();
    }
}
