package com.pjatk.mas.project.cars.model.person.employees;

import com.pjatk.mas.project.cars.model.education.College;
import com.pjatk.mas.project.cars.model.education.University;
import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class HR extends Employee {

    //Association with university
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "university_hr",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "university_id")
    )
    private final Set<University> universities = new HashSet<>();

    //Association with college
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "college_hr",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "college_id")
    )
    private final Set<College> colleges = new HashSet<>();

    public HR(){ super();}

    public HR(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate, double salary, @NotBlank String workEmail,
                   @NotNull EmployeeStatus employeeStatus, LocalDate hireDate, LocalDate internshipStartDate, LocalDate internshipEndDate){
        super(name, surname, birthdate, salary, workEmail, employeeStatus, hireDate, internshipStartDate, internshipEndDate);
    }

    public Set<University> getUniversities() {
        return new HashSet<>(universities);
    }

    public Set<College> getColleges() {
        return new HashSet<>(colleges);
    }

    public void addCollege(@NotNull College college) {
        if(universities.size() == 0) {
            if(!colleges.contains(college)) {
                colleges.add(college);
                college.addToTeaches(this);
            }
        } else {
            System.err.println("This student already attends university");
        }
    }

    public void removeCollege(@NotNull College college) {
        if(colleges.contains(college)) {
            colleges.remove(college);
            college.removeFromTeaches(this);
        }
    }

    public void addUniversity(@NotNull University university) {
        if(colleges.size() == 0) {
            if(!universities.contains(university)) {
                universities.add(university);
                university.addToTeaches(this);
            }
        } else {
            //TODO: replace
            throw new IllegalArgumentException("This student already attends college");
        }
    }

    public void removeUniversity(@NotNull University university) {
        if (universities.contains(university)) {
            universities.remove(university);
            university.removeFromTeaches(this);
        }
    }
}
