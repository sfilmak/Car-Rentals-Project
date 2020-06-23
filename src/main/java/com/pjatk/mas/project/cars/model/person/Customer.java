package com.pjatk.mas.project.cars.model.person;

import com.pjatk.mas.project.cars.model.CarRental;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Customer")
@Table(name = "customer")
@AttributeOverride(name="id", column=@Column(name = "CUSTOMER_ID"))
public class Customer extends Person<Long> {

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    //Association with a CarRental
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    private final Set<CarRental> carRentals = new HashSet<>();

    @NotNull
    @OneToOne(mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY, optional = false)
    private DrivingLicense drivingLicense;

    public Customer(){
        super();
    }

    public Customer(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate,
                    @NotBlank String email, @NotBlank String phoneNumber, @NotBlank String address,
                    //Driving license part (composition):
                    @NotNull Long licenseID, @NotNull LocalDate dateOfIssue,
                    @NotBlank String countryOfIssue) {
        super(name, surname, birthdate);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
        DrivingLicense drivingLicense = new DrivingLicense(licenseID, dateOfIssue, countryOfIssue, this);
        this.setDrivingLicense(drivingLicense);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCustomer(@NotNull CarRental carRental) {
        if(!carRentals.contains(carRental)) {
            carRentals.add(carRental);
            carRental.setCustomer(this);
        }
    }

    public void changeCustomer(@NotNull CarRental carRental, @NotNull Customer newCustomer) {
        if(carRentals.contains(carRental)) {
            carRentals.remove(carRental);
            carRental.setCustomer(newCustomer);
        }
    }

    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    private void setDrivingLicense(DrivingLicense drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Set<CarRental> getCarRentals() {
        return carRentals;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", carRentals=" + carRentals +
                ", drivingLicense=" + drivingLicense +
                '}';
    }
}
