package com.pjatk.mas.project.cars;

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
			/*Car car1 = new Car("Toyota", "Corolla",
					"https://habrastorage.org/webt/qf/fh/9p/qffh9puwalhraccfofxu1nnofaw.jpeg", 80);

			Car car2 = new Car("Tesla", "Model Y",
					"https://habrastorage.org/webt/4o/z3/5i/4oz35iflygfg479mt2n6huxikae.jpeg", 120);

			Car car3 = new Car("Nissan", "GT-R",
					"https://habrastorage.org/webt/4s/fi/rf/4sfirf_erjrkzd2pubizoveaape.jpeg", 450);

			Car car4 = new Car("BMW", "M5",
					"https://habrastorage.org/webt/xc/-c/cn/xc-ccn29eozxwtbqm0afhx41_98.jpeg", 300);

			Car car5 = new Car("Opel", "Corsa",
					"https://habrastorage.org/webt/lk/vk/ru/lkvkruwctugtfpt8hlh9rt_h-ck.png", 75);

			Car car6 = new Car("Audi", "A8",
					"https://habrastorage.org/webt/lj/gu/ro/ljgurorjneji161ilvun73vq7cm.jpeg", 150);

			Car car7 = new Car("Lancia", "Delta Integrale",
					"https://habrastorage.org/webt/dj/al/1d/djal1dabjud95pqqgzbuq9j6w0s.jpeg", 100);

			Car car8 = new Car("Ford", "Fiesta ST",
					"https://habrastorage.org/webt/e_/tl/cl/e_tlclbcjsxexkdinftnafbtgqo.jpeg", 120);

			Car car9 = new Car("Skoda", "Rapid",
					"https://habrastorage.org/webt/b4/-d/bz/b4-dbzgsm0exxwenszogrwqak3u.jpeg", 60);

			Car car10 = new Car("Audi", "A3",
					"https://habrastorage.org/webt/ar/9u/yz/ar9uyzikg_id4ilafhv9b3412ca.jpeg", 90);

			carRepo.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10));*/
		};
	}

}
