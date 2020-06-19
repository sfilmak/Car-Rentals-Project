package com.pjatk.mas.project.cars;

import com.pjatk.mas.project.cars.model.Car;
import com.pjatk.mas.project.cars.repos.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@SpringBootApplication
public class CarSellingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSellingProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CarRepository carRepo) {
		return (args) -> {
			/*Car car1 = new Car("Toyota", "Corolla", "Blue", "Hatchback", LocalDate.of(2019, Month.DECEMBER, 12),
					80, "https://habrastorage.org/webt/qf/fh/9p/qffh9puwalhraccfofxu1nnofaw.jpeg");

			Car car2 = new Car("Tesla", "Model Y", "Red", "SUV", LocalDate.of(2020, Month.APRIL, 26),
					120, "https://habrastorage.org/webt/4o/z3/5i/4oz35iflygfg479mt2n6huxikae.jpeg");

			Car car3 = new Car("Nissan", "GT-R", "White", "Sport", LocalDate.of(2009, Month.NOVEMBER, 10), 450,
					"https://habrastorage.org/webt/4s/fi/rf/4sfirf_erjrkzd2pubizoveaape.jpeg");

			Car car4 = new Car("BMW", "M5", "Silver", "Sedan", LocalDate.of(2020, Month.JANUARY, 16), 300,
					"https://habrastorage.org/webt/xc/-c/cn/xc-ccn29eozxwtbqm0afhx41_98.jpeg");

			Car car5 = new Car("Opel", "Corsa", "Orange", "Hatchback", LocalDate.of(2020, Month.MARCH, 5), 75,
					"https://habrastorage.org/webt/lk/vk/ru/lkvkruwctugtfpt8hlh9rt_h-ck.png");

			Car car6 = new Car("Audi", "A8", "Silver", "Sedan", LocalDate.of(2018, Month.AUGUST, 12), 150,
					"https://habrastorage.org/webt/lj/gu/ro/ljgurorjneji161ilvun73vq7cm.jpeg");

			Car car7 = new Car("Lancia", "Delta Integrale", "Red", "Hatchback", LocalDate.of(1984, Month.APRIL, 12), 100,
					"https://habrastorage.org/webt/dj/al/1d/djal1dabjud95pqqgzbuq9j6w0s.jpeg");

			Car car8 = new Car("Ford", "Fiesta ST", "Orange", "Hatchback", LocalDate.of(2017, Month.JUNE, 23),120,
					"https://habrastorage.org/webt/e_/tl/cl/e_tlclbcjsxexkdinftnafbtgqo.jpeg");

			Car car9 = new Car("Skoda", "Rapid", "White", "Sedan", LocalDate.of(2019, Month.SEPTEMBER, 14), 60,
					"https://habrastorage.org/webt/b4/-d/bz/b4-dbzgsm0exxwenszogrwqak3u.jpeg");

			Car car10 = new Car("Audi", "A3", "Blue", "Hatchbac", LocalDate.of(2020, Month.MAY, 6), 90,
					"https://habrastorage.org/webt/ar/9u/yz/ar9uyzikg_id4ilafhv9b3412ca.jpeg");

			carRepo.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10));*/
		};
	}

}
