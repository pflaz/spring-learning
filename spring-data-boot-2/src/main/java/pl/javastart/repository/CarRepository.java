package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    Car findFirstByBrand(String brand);
    Car findFirstByPrice(double price);
    List<Car> findFirst3ByBrand(String brand);
    


}
