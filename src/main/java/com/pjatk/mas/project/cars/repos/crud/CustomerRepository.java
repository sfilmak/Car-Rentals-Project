package com.pjatk.mas.project.cars.repos.crud;

import com.pjatk.mas.project.cars.model.person.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
