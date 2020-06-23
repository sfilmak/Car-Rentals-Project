package com.pjatk.mas.project.cars.model.education;

import com.pjatk.mas.project.cars.model.person.employees.HR;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "University")
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long universityID;

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    //Association with HRs
    @ManyToMany(mappedBy = "universities")
    @NotNull
    private Set<HR> HRs = new HashSet<>();

    public University(){}

    public University(@NotBlank String name, @NotBlank String city, @NotBlank String country) {
        this.setName(name);
        this.setCity(city);
        this.setCountry(country);
    }

    public Long getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Long universityID) {
        this.universityID = universityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<HR> getHRs() {
        return new HashSet<>(HRs);
    }

    public void setHRs(Set<HR> HRs) {
        this.HRs = HRs;
    }

    public void addToTeaches(@NotNull HR hr) {
        if(hr == null) {
            throw new IllegalArgumentException("hr cannot be null");
        }
        if(!HRs.contains(hr) && hr.getColleges().size() == 0) {
            HRs.add(hr);
            hr.addUniversity(this);
        }
    }

    public void removeFromTeaches(@NotNull HR hr) {
        if(hr == null) {
            throw new IllegalArgumentException("hr cannot be null");
        }
        if(HRs.contains(hr)) {
            HRs.remove(hr);
            hr.removeUniversity(this);
        }
    }

    @Override
    public String toString() {
        return "University{" +
                "universityID=" + universityID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
