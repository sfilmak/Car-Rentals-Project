package com.pjatk.mas.project.cars.model.person.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pjatk.mas.project.cars.model.OrderBonus;
import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Consultant extends Employee {

    @NotBlank
    private String workAddress;

    //Association with an OrderBonus
    @OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    @JsonIgnore
    private final Set<OrderBonus> orderBonuses = new HashSet<>();

    public Consultant(){ super(); }

    public Consultant(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate, double salary,
                      @NotBlank String workEmail, @NotNull EmployeeStatus employeeStatus, LocalDate hireDate,
                      LocalDate internshipStartDate, LocalDate internshipEndDate, @NotBlank String workAddress){
        super(name, surname, birthdate, salary, workEmail, employeeStatus, hireDate, internshipStartDate, internshipEndDate);
        this.setWorkAddress(workAddress);
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Set<OrderBonus> getOrderBonuses() {
        return new HashSet<>(orderBonuses);
    }

    public void addOrderBonus(OrderBonus orderBonus) {
        if(orderBonus == null) {
            throw new IllegalArgumentException("Order bonus attribute cannot be null");
        }
        if(!this.orderBonuses.contains(orderBonus)) {
            orderBonuses.add(orderBonus);
        }
    }

    //It is not possible to remove order bonus
    //Because of the 1-1 relation between OrderBonus and CarRental
    //It means that Consultant will always get a bonus
    //for any rental, but this bonus may be set to 0
}
