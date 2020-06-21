package com.pjatk.mas.project.cars.model.person.employees;

import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Consultant extends Employee {

    @NotBlank
    private String workAddress;

    public Consultant(){
        super();
    }

    public Consultant(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate, double salary, @NotBlank String workEmail,
                      @NotNull EmployeeStatus employeeStatus, LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate,
                      @NotBlank String workAddress){
        super(name, surname, birthdate, salary, workEmail, employeeStatus, hireDate, internshipStartDate, internshipEndDate);
        this.setWorkAddress(workAddress);
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
