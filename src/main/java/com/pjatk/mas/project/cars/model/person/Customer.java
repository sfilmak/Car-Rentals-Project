package com.pjatk.mas.project.cars.model.person;

import com.pjatk.mas.project.cars.model.CarRental;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    //One-to-one relation sing foreign key
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "licenseID", referencedColumnName = "licenseID")
    private DrivingLicense drivingLicense;

    //Association with a CarRental
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @NotNull
    @Column(nullable = false)
    private final Set<CarRental> carRentals = new HashSet<>();

    public Customer(){
        super();
    }

    public Customer(@NotBlank String name, @NotBlank String surname, @NotNull LocalDate birthdate,
                    @NotBlank String email, @NotBlank String phoneNumber, @NotBlank String address,
                    @NotNull DrivingLicense drivingLicense) {
        super(name, surname, birthdate);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setAddress(address);
        this.setDrivingLicense(drivingLicense);
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
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

    public DrivingLicense getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(DrivingLicense drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public void addCustomer(CarRental carRental) {
        if(!carRentals.contains(carRental)) {
            carRentals.add(carRental);
            carRental.setCustomer(this);
        }
    }

    public void removeCustomer(CarRental carRental, Customer newCustomer) {
        if(carRentals.contains(carRental)) {
            carRentals.remove(carRental);
            carRental.setCustomer(newCustomer);
        }
    }
}
