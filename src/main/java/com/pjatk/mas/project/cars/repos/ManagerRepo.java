package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.person.employees.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {}
