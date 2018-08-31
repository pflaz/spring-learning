package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.model.Car;
import pl.javastart.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));

        CarRepository carRepository = ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        System.out.println("FindByBrand - Audi:");
        carRepository.findByBrand("Audi").forEach(System.out::println);



        Car firstCar = carRepository.findOne(1L);
        carRepository.delete(firstCar);



        carRepository.findAll().forEach(System.out::println);

        ctx.close();
    }
}
