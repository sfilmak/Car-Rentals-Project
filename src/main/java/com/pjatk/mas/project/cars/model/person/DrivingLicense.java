package com.pjatk.mas.project.cars.model.person;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity(name = "DrivingLicense")
@Table(name = "driving_license")
public class DrivingLicense {

    @Id
    @NotNull
    private Long licenseID;

    @NotNull
    @Column(columnDefinition = "DATE")
    @Past
    private LocalDate dateOfIssue;

    @NotBlank
    private String countryOfIssue;

    //Mentioned to be the most efficient one-to-one
    //association in JPA: https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Customer customer;

    private static final int allowedAgeForDriving = 18;

    public DrivingLicense(){}

    public DrivingLicense(@NotNull Long licenseID, @NotNull LocalDate dateOfIssue,
                          @NotBlank String countryOfIssue, @NotNull Customer customer) {
        this.setLicenseID(licenseID);
        this.setDateOfIssue(dateOfIssue);
        this.setCountryOfIssue(countryOfIssue);
        this.setCustomer(customer);
    }

    public Long getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(Long licenseID) {
        this.licenseID = licenseID;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public static int getAllowedAgeForDriving() {
        return allowedAgeForDriving;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
