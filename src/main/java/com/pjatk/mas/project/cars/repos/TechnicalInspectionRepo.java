package com.pjatk.mas.project.cars.repos;

import com.pjatk.mas.project.cars.model.vehicle.TechnicalInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalInspectionRepo extends JpaRepository<TechnicalInspection, Long> { }
