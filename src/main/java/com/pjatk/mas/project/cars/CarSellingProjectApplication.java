package com.pjatk.mas.project.cars;

import com.pjatk.mas.project.cars.model.CarRental;
import com.pjatk.mas.project.cars.model.OrderBonus;
import com.pjatk.mas.project.cars.model.education.University;
import com.pjatk.mas.project.cars.model.enums.EmployeeStatus;
import com.pjatk.mas.project.cars.model.enums.EngineType;
import com.pjatk.mas.project.cars.model.enums.InspectionType;
import com.pjatk.mas.project.cars.model.enums.RentalStatus;
import com.pjatk.mas.project.cars.model.person.Customer;
import com.pjatk.mas.project.cars.model.person.employees.Consultant;
import com.pjatk.mas.project.cars.model.person.employees.HR;
import com.pjatk.mas.project.cars.model.person.employees.Mechanic;
import com.pjatk.mas.project.cars.model.vehicle.Car;
import com.pjatk.mas.project.cars.model.vehicle.Specialization;
import com.pjatk.mas.project.cars.model.vehicle.TechnicalInspection;
import com.pjatk.mas.project.cars.repos.*;
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
									HRRepo hrRepo,
									CarRepository carRepo,
									OrderBonusRepo orderBonusRepo) {
		return (args) -> {
			Car car1 = new Car("Toyota", "Corolla", "Blue", "Hatchback", LocalDate.of(2019, Month.DECEMBER, 12),
					80, "https://habrastorage.org/webt/qf/fh/9p/qffh9puwalhraccfofxu1nnofaw.jpeg",
					"Toyota Engine", EngineType.HYBRID);

			Car car2 = new Car("Tesla", "Model Y", "Red", "SUV", LocalDate.of(2020, Month.APRIL, 26),
					120, "https://habrastorage.org/webt/4o/z3/5i/4oz35iflygfg479mt2n6huxikae.jpeg",
					"Tesla Engine", EngineType.ELECTRIC);

			Car car3 = new Car("Nissan", "GT-R", "White", "Sport", LocalDate.of(2009, Month.NOVEMBER, 10), 450,
					"https://habrastorage.org/webt/4s/fi/rf/4sfirf_erjrkzd2pubizoveaape.jpeg",
					"Nissan Engine", EngineType.PETROL, 4.0f, 8);

			Car car4 = new Car("BMW", "M5", "Silver", "Sedan", LocalDate.of(2020, Month.JANUARY, 16), 300,
					"https://habrastorage.org/webt/xc/-c/cn/xc-ccn29eozxwtbqm0afhx41_98.jpeg",
					"BMW Engine", EngineType.PETROL, 3.2f, 8);

			Car car5 = new Car("Opel", "Corsa", "Orange", "Hatchback", LocalDate.of(2020, Month.MARCH, 5), 75,
					"https://habrastorage.org/webt/lk/vk/ru/lkvkruwctugtfpt8hlh9rt_h-ck.png",
					"Opel Engine", EngineType.ELECTRIC);

			Car car6 = new Car("Audi", "A8", "Silver", "Sedan", LocalDate.of(2018, Month.AUGUST, 12), 150,
					"https://habrastorage.org/webt/lj/gu/ro/ljgurorjneji161ilvun73vq7cm.jpeg",
					"Audi Engine", EngineType.DIESEL, 3.0f, 6);

			Car car7 = new Car("Lancia", "Delta Integrale", "Red", "Hatchback", LocalDate.of(1984, Month.APRIL, 12), 100,
					"https://habrastorage.org/webt/dj/al/1d/djal1dabjud95pqqgzbuq9j6w0s.jpeg",
					"Lancia Engine", EngineType.PETROL, 1.6f, 4);

			Car car8 = new Car("Ford", "Fiesta ST", "Orange", "Hatchback", LocalDate.of(2017, Month.JUNE, 23),120,
					"https://habrastorage.org/webt/e_/tl/cl/e_tlclbcjsxexkdinftnafbtgqo.jpeg",
					"Ford Engine", EngineType.PETROL, 1.4f, 3);

			Car car9 = new Car("Skoda", "Rapid", "White", "Sedan", LocalDate.of(2019, Month.SEPTEMBER, 14), 60, 186.5f,
					"https://habrastorage.org/webt/b4/-d/bz/b4-dbzgsm0exxwenszogrwqak3u.jpeg",
					"Skoda Engine", EngineType.DIESEL, 1.6f, 4);

			Car car10 = new Car("Audi", "A3", "Blue", "Hatchback", LocalDate.of(2020, Month.MAY, 6), 90, 200f,
					"https://habrastorage.org/webt/ar/9u/yz/ar9uyzikg_id4ilafhv9b3412ca.jpeg",
					"Audi Engine", EngineType.ELECTRIC);

			carRepo.saveAll(Arrays.asList(car4, car5, car6, car7, car8, car9, car10));

			Customer customer1 = new Customer("Oleksandr", "Sidletskyi", LocalDate.of(1999, Month.MAY, 25),
					"sidl@gmail.com", "+228", "Nye tvoe delo street",
					228L, LocalDate.of(2019, Month.JUNE, 5), "Polska");

			Customer customer2 = new Customer("Artsiom", "Paliaschuk", LocalDate.of(2000, Month.MAY, 6),
					"pal@gmail.com", "+48328382324", "Stara Praga",
					229L, LocalDate.of(2020, Month.JANUARY, 20), "Belarus");

			Consultant consultant1 = new Consultant("Yuta", "Maejima", LocalDate.of(1999, Month.OCTOBER, 4), 15000,
					"ksks@gmail.com", EmployeeStatus.FULLTIME, LocalDate.of(2020, Month.JANUARY, 16),
					null, null, "Warsaw");

			CarRental carRental1 = new CarRental(LocalDate.of(2020, Month.AUGUST, 22), LocalDate.of(2020, Month.AUGUST, 24), "Comments", RentalStatus.PLANNED, car1, customer1);
			CarRental carRental2 = new CarRental(LocalDate.of(2020, Month.JULY, 22), LocalDate.of(2020, Month.JULY, 24), "Another message example", RentalStatus.PLANNED, car2, customer2);

			OrderBonus orderBonus = new OrderBonus(500, carRental1, consultant1);
			OrderBonus orderBonus2 = new OrderBonus(400, carRental2, consultant1);

			orderBonusRepo.saveAll(Arrays.asList(orderBonus, orderBonus2));

			HR newHR = new HR("Viktor", "Litovchenko", LocalDate.of(2000, Month.MAY, 28),
					3000, "nu_da@gmail.com", EmployeeStatus.FULLTIME, LocalDate.of(2010, Month.MAY, 12), null, null);

			newHR.addUniversity(new University("PJATK", "Warsaw", "Poland"));

			hrRepo.save(newHR);

			Specialization specialization = new Specialization("Strong", InspectionType.ENGINE);

			Mechanic newMechanic = new Mechanic("Viktor", "Litovchenko", LocalDate.of(2000, Month.MAY, 28),
					3000, "nu_da@gmail.com", EmployeeStatus.FULLTIME, LocalDate.of(2010, Month.MAY, 12), null, null,
					specialization);

			TechnicalInspection technicalInspection = new TechnicalInspection(LocalDate.of(2020, Month.JULY, 29), true, 150000L, InspectionType.ENGINE, car3, newMechanic);
			techRepo.save(technicalInspection);
		};
	}
}
