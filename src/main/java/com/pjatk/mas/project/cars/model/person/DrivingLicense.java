package com.pjatk.mas.project.cars.model.person;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.Period;

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

    //https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
    //Not the best one, but it allows us
    //to keep reference to Driving License from Customer class
    //and keep reference to Customer from Driving License class
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    private static final int allowedAgeForDriving = 18;

    public DrivingLicense(){}

    DrivingLicense(@NotNull Long licenseID, @NotNull LocalDate dateOfIssue,
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

    public static boolean isAllowedInPoland(DrivingLicense drivingLicense){
        return Period.between(drivingLicense.getCustomer().getBirthdate(), LocalDate.now()).getYears() >= allowedAgeForDriving;
    }

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "licenseID=" + licenseID +
                ", dateOfIssue=" + dateOfIssue +
                ", countryOfIssue='" + countryOfIssue + '\'' +
                ", customer=" + customer +
                '}';
    }
}
