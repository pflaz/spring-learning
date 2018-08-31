package pl.javastart.repository;

import org.springframework.data.repository.CrudRepository;
import pl.javastart.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
