package com.pjatk.mas.project.cars.model.education;

import com.pjatk.mas.project.cars.model.person.employees.HR;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "College")
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long collegeID;

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    //Association with HRs
    @ManyToMany(mappedBy = "colleges")
    @NotNull
    private Set<HR> HRs = new HashSet<>();

    public College(){}

    public College(@NotBlank String name, @NotBlank String city) {
        this.setName(name);
        this.setCity(city);
    }

    public Long getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(Long collegeID) {
        this.collegeID = collegeID;
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
        if(!HRs.contains(hr) && hr.getUniversities().size() == 0) {
            HRs.add(hr);
            hr.addCollege(this);
        }
    }

    public void removeFromTeaches(@NotNull HR hr) {
        if(hr == null) {
            throw new IllegalArgumentException("hr cannot be null");
        }
        if(HRs.contains(hr)) {
            HRs.remove(hr);
            hr.removeCollege(this);
        }
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeID=" + collegeID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
