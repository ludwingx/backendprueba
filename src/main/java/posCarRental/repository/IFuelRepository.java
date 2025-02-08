package posCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posCarRental.entity.Fuel;

@Repository
public interface IFuelRepository extends JpaRepository<Fuel, Long> {
}
