package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.person.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
