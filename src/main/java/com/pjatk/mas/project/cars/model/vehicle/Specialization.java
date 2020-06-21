package com.pjatk.mas.project.cars.model.vehicle;

import com.pjatk.mas.project.cars.model.enums.InspectionType;
import com.pjatk.mas.project.cars.model.person.employees.Mechanic;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Specialization")
@Table(name = "specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specializationID;

    @NotBlank
    private String experience;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InspectionType inspectionType;

    //Association with a Mechanic
    @OneToMany(mappedBy = "specialization", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    private final Set<Mechanic> mechanics = new HashSet<>();

    public Specialization() {}

    public Specialization(@NotBlank String experience, @NotNull InspectionType inspectionType) {
        this.setExperience(experience);
        this.setInspectionType(inspectionType);
    }

    public Long getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(Long specializationID) {
        this.specializationID = specializationID;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public InspectionType getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(InspectionType inspectionType) {
        this.inspectionType = inspectionType;
    }

    public void addMechanic(Mechanic mechanic) {
        if(!mechanics.contains(mechanic)) {
            mechanics.add(mechanic);
            mechanic.setSpecialization(this);
        }
    }

    public void changeSpecialization(Mechanic mechanic, Specialization newSpecialization) {
        if(mechanics.contains(mechanic)) {
            mechanics.remove(mechanic);
            mechanic.setSpecialization(newSpecialization);
        }
    }
}
