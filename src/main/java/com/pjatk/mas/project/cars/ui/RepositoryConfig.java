package com.pjatk.mas.project.cars.ui;

import com.pjatk.mas.project.cars.model.person.Customer;
import com.pjatk.mas.project.cars.model.person.DrivingLicense;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Car.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(DrivingLicense.class);
    }
}