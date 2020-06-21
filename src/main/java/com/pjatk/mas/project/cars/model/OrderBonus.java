package com.pjatk.mas.project.cars.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pjatk.mas.project.cars.model.person.employees.Consultant;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderBonus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderBonusID;

    private double bonusForOrder;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private CarRental carRental;

    @NotNull(message = "OrderBonus should have a consultant!")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonManagedReference
    @RestResource(exported=false)
    private Consultant consultant;

    public OrderBonus(double bonusForOrder, @NotNull CarRental carRental, @NotNull(message = "OrderBonus should have a consultant!") Consultant consultant) {
        this.setBonusForOrder(bonusForOrder);
        this.setCarRental(carRental);
        this.setConsultant(consultant);
    }

    public Long getOrderBonusID() {
        return orderBonusID;
    }

    public void setOrderBonusID(Long orderBonusID) {
        this.orderBonusID = orderBonusID;
    }

    public double getBonusForOrder() {
        return bonusForOrder;
    }

    public void setBonusForOrder(double bonusForOrder) {
        this.bonusForOrder = bonusForOrder;
    }

    public CarRental getCarRental() {
        return carRental;
    }

    private void setCarRental(CarRental carRental) {
        this.carRental = carRental;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    private void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }
}
