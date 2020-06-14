package com.pjatk.mas.project.cars;

import com.pjatk.mas.project.cars.model.Car;
import com.pjatk.mas.project.cars.repos.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarSellingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSellingProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CarRepository carRepo) {
		return (args) -> {
			Car car1 = new Car("Jaguar", "E-Type");
			carRepo.save(car1);

			Car car2 = new Car("Tesla", "Model Y");
			carRepo.save(car2);
		};
	}

}
