package com.pjatk.mas.project.cars.model.person.employees;

import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Manager extends Employee {

    public Manager(){
        super();
    }

    public Manager(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate, double salary, @NotBlank String workEmail,
                      @NotNull EmployeeStatus employeeStatus, LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate){
        super(name, surname, birthdate, salary, workEmail, employeeStatus, hireDate, internshipStartDate, internshipEndDate);
    }
}
