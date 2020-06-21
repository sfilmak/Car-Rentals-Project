package com.pjatk.mas.project.cars;

import com.pjatk.mas.project.cars.model.CarRental;
import com.pjatk.mas.project.cars.model.education.College;
import com.pjatk.mas.project.cars.model.education.University;
import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;
import com.pjatk.mas.project.cars.model.enums.RentalStatus;
import com.pjatk.mas.project.cars.model.person.Customer;
import com.pjatk.mas.project.cars.model.person.DrivingLicense;
import com.pjatk.mas.project.cars.model.person.employees.HR;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import com.pjatk.mas.project.cars.repos.crud.*;
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
	public CommandLineRunner runner(CustomerRepository customerRepo,
									EngineRepo engineRepo,
									CarRentalRepository carRentalRepo,
									TechnicalInspectionRepo techRepo,
									DrivingLicenseRepository drivingLicenseRepo,
									HRRepo hrRepo) {
		return (args) -> {
			Car car1 = new Car("Toyota", "Corolla", "Blue", "Hatchback", LocalDate.of(2019, Month.DECEMBER, 12),
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

			Car car9 = new Car("Skoda", "Rapid", "White", "Sedan", LocalDate.of(2019, Month.SEPTEMBER, 14), 60, 186.5f,
					"https://habrastorage.org/webt/b4/-d/bz/b4-dbzgsm0exxwenszogrwqak3u.jpeg");

			Car car10 = new Car("Audi", "A3", "Blue", "Hatchback", LocalDate.of(2020, Month.MAY, 6), 90, 200f,
					"https://habrastorage.org/webt/ar/9u/yz/ar9uyzikg_id4ilafhv9b3412ca.jpeg");


			Customer customer1 = new Customer("Oleksandr", "Sidletskyi", LocalDate.of(1999, Month.MAY, 25),
					"sidl@gmail.com", "+228", "Nye tvoe delo street");

			Customer customer2 = new Customer("Artsiom", "Paliaschuk", LocalDate.of(2000, Month.MAY, 6),
					"pal@gmail.com", "+48328382324", "Stara Praga");

			DrivingLicense drivingLicense = new DrivingLicense(228L, LocalDate.of(2019, Month.JUNE, 5), "Polska", customer1);
			DrivingLicense drivingLicense2 = new DrivingLicense(229L, LocalDate.of(2020, Month.JANUARY, 20), "Belarus", customer2);

			CarRental carRental1 = new CarRental(LocalDate.of(2020, Month.JUNE, 22), LocalDate.of(2020, Month.JUNE, 24), "Comments", RentalStatus.PLANNED, car1, customer1);
			CarRental carRental2 = new CarRental(LocalDate.of(2020, Month.JULY, 22), LocalDate.of(2020, Month.JULY, 24), "Comments", RentalStatus.PLANNED, car2, customer2);
			carRentalRepo.saveAll(Arrays.asList(carRental1, carRental2));
			drivingLicenseRepo.saveAll(Arrays.asList(drivingLicense, drivingLicense2));

			HR newHR = new HR("Viktor", "Litovchenko", LocalDate.of(2000, Month.MAY, 28),
					3000, "nu_da@gmail.com", EmployeeStatus.FULLTIME, LocalDate.of(2010, Month.MAY, 12), null, null);

			newHR.addUniversity(new University("PJATK", "Warsaw", "Poland"));

			hrRepo.save(newHR);
			//TechnicalInspection technicalInspection = new TechnicalInspection(LocalDate.of(2020, Month.JANUARY, 12), true, 150000L, InspectionType.ENGINE, car1);
			//techRepo.save(technicalInspection);
			//carRepo.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10));
			//customerRepo.save(customer);
			//Engine engine = Engine.createEngine(car2, "Name", EngineType.ELECTRIC);
			//engineRepo.save(engine);

		};
	}

}
