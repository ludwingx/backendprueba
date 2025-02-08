package posCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posCarRental.entity.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
}
