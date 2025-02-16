package com.pjatk.mas.project.cars.model.person.employees;

import com.pjatk.mas.project.cars.model.person.Person;
import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;

//Joined table strategy
//https://www.tutorialspoint.com/jpa/jpa_advanced_mappings.htm
@Entity
@AttributeOverride(name="id", column=@Column(name = "EMPLOYEE_ID"))
@Inheritance( strategy = InheritanceType.JOINED )
public class Employee extends Person<Long> implements Serializable {

    private double salary;

    @NotBlank
    private String workEmail;

    @Column(columnDefinition = "DATE")
    @PastOrPresent
    private LocalDate hireDate;

    @Column(columnDefinition = "DATE")
    private LocalDate internshipStartDate;

    @Column(columnDefinition = "DATE")
    @FutureOrPresent
    private LocalDate internshipEndDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EmployeeStatus employeeStatus;

    public Employee(){
        super();
    }

    public Employee(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate, double salary, @NotBlank String workEmail,
                    @NotNull EmployeeStatus employeeStatus, LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate) {
        super(name, surname, birthdate);
        this.setSalary(salary);
        this.setWorkEmail(workEmail);
        this.setEmployeeStatus(employeeStatus, hireDate, internshipStartDate, internshipEndDate);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary <= 0){
            throw new IllegalArgumentException("Salary should be bigger than 0!");
        }
        this.salary = salary;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        if(this.getEmployeeStatus() == EmployeeStatus.FULLTIME) {
            if(hireDate == null) {
                throw new IllegalArgumentException("Hire date cannot be null if employee status is FULLTIME WORKER");
            }
        } else if(this.getEmployeeStatus() == EmployeeStatus.INTERN) {
            if(hireDate != null) {
                throw new IllegalArgumentException("Hire date cannot be set if the status is " + this.getEmployeeStatus().toString());
            }
        }
        this.hireDate = hireDate;
    }

    public LocalDate getInternshipStartDate() {
        return internshipStartDate;
    }

    public void setInternshipStartDate(LocalDate internshipStartDate) {
        if(this.getEmployeeStatus() == EmployeeStatus.INTERN) {
            if(internshipStartDate == null) {
                throw new IllegalArgumentException("Internship start date cannot be null if employee status is INTERN");
            }
        } else if(this.getEmployeeStatus() == EmployeeStatus.FULLTIME) {
            if(internshipStartDate != null) {
                throw new IllegalArgumentException("Internship start date cannot be set if the status is " + this.getEmployeeStatus().toString());
            }
        }

        this.internshipStartDate = internshipStartDate;
    }

    public LocalDate getInternshipEndDate() {
        return internshipEndDate;
    }

    public void setInternshipEndDate(LocalDate internshipEndDate) {
        if(this.getEmployeeStatus() == EmployeeStatus.INTERN) {
            if(internshipEndDate == null) {
                throw new IllegalArgumentException("Internship end date cannot be null if employee status is INTERN");
            }
        } else if(this.getEmployeeStatus() == EmployeeStatus.FULLTIME) {
            if(internshipEndDate != null) {
                throw new IllegalArgumentException("Internship end date cannot be set if the status is " + this.getEmployeeStatus().toString());
            }
        }

        this.internshipEndDate = internshipEndDate;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus, LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate) {
        if(employeeStatus == null) {
            throw new IllegalArgumentException("Employee status cannot be null");
        }

        this.employeeStatus = employeeStatus;

        if(employeeStatus == EmployeeStatus.INTERN) {
            this.setInternshipStartDate(internshipStartDate);
            this.setInternshipEndDate(internshipEndDate);
            this.setHireDate(null);
        } else if(employeeStatus == EmployeeStatus.FULLTIME) {
            this.setHireDate(hireDate);
            this.setInternshipStartDate(null);
            this.setInternshipEndDate(null);
        }
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", workEmail='" + workEmail + '\'' +
                ", hireDate=" + hireDate +
                ", internshipStartDate=" + internshipStartDate +
                ", internshipEndDate=" + internshipEndDate +
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}
