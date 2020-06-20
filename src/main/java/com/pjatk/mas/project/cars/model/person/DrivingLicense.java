package com.pjatk.mas.project.cars.model.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class DrivingLicense {

    @Id
    @NotNull
    private Long licenseID;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate dateOfIssue;

    @NotBlank
    private String countryOfIssue;

    private static final int allowedAgeForDriving = 18;

    public DrivingLicense(){}

    public DrivingLicense(@NotNull Long licenseID, @NotNull LocalDate dateOfIssue, @NotBlank String countryOfIssue) {
        this.setLicenseID(licenseID);
        this.setDateOfIssue(dateOfIssue);
        this.setCountryOfIssue(countryOfIssue);
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
}
