package com.pjatk.mas.project.cars.model.person.employees;

import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;
import com.pjatk.mas.project.cars.model.vehicle.Specialization;
import com.pjatk.mas.project.cars.model.vehicle.TechnicalInspection;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Mechanic")
@Table(name = "mechanic")
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Mechanic extends Employee {

    @NotNull(message = "Mechanic should have a specialization!")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "specialization_id", nullable = false)
    private Specialization specialization;

    //Association with a Technical Inspection
    @OneToMany(mappedBy = "mechanic", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    private final Set<TechnicalInspection> technicalInspectionsSet = new HashSet<>();

    public Mechanic(){
        super();
    }

    public Mechanic(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate,
                    double salary, @NotBlank String workEmail, @NotNull EmployeeStatus employeeStatus,
                    LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate,
                    @NotNull Specialization specialization){
        super(name, surname, birthdate, salary, workEmail, employeeStatus, hireDate, internshipStartDate, internshipEndDate);
        this.setSpecialization(specialization);
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        if(this.specialization != specialization) {
            if(this.specialization != null) {
                Specialization tmp = this.specialization;
                this.specialization = null;
                tmp.changeSpecialization(this, specialization);
            }
            this.specialization = specialization;
            if(specialization != null) {
                specialization.addMechanic(this);
            }
        }
    }

    public void addTechnicalInspection(TechnicalInspection technicalInspection) {
        if(!technicalInspectionsSet.contains(technicalInspection)) {
            technicalInspectionsSet.add(technicalInspection);
            technicalInspection.setMechanic(this);
        }
    }

    public void changeTechnicalInspection(TechnicalInspection technicalInspection, Mechanic newMechanic) {
        if(technicalInspectionsSet.contains(technicalInspection)) {
            technicalInspectionsSet.remove(technicalInspection);
            technicalInspection.setMechanic(newMechanic);
        }
    }
}
