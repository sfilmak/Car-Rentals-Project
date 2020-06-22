package com.pjatk.mas.project.cars.model.person;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

//https://gist.github.com/banterCZ/6164973
@MappedSuperclass
public abstract class Person<PK extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PK id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    @Column(columnDefinition = "DATE")
    @Past
    private LocalDate birthdate;

    public Person(){}

    public Person(@NotBlank String name, @NotBlank String surname, @NotNull @Past LocalDate birthdate) {
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

    //Derived attribute
    public int getAge(){
        return Period.between(getBirthdate(), LocalDate.now()).getYears();
    }

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person<?> other = (Person<?>) obj;
        if (getId() == null || other.getId() == null) {
            return false;
        }
        return getId().equals(other.getId());
    }
}
