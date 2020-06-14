package com.pjatk.mas.project.cars;

import com.pjatk.mas.project.cars.model.Car;
import com.pjatk.mas.project.cars.repos.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

@SpringBootApplication
public class CarSellingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSellingProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CarRepository carRepo) {
		return (args) -> {
			Car car1 = new Car("Toyota", "Corolla",
					"https://habrastorage.org/webt/qf/fh/9p/qffh9puwalhraccfofxu1nnofaw.jpeg", 80);

			Car car2 = new Car("Tesla", "Model Y",
					"https://habrastorage.org/webt/4o/z3/5i/4oz35iflygfg479mt2n6huxikae.jpeg", 120);
			Car car3 = new Car("Nissan", "GT-R",
					"https://habrastorage.org/webt/4s/fi/rf/4sfirf_erjrkzd2pubizoveaape.jpeg", 400);

			carRepo.saveAll(Arrays.asList(car1, car2, car3));
		};
	}

}
