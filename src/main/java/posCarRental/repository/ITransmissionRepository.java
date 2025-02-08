package posCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posCarRental.entity.Transmission;

@Repository
public interface ITransmissionRepository extends JpaRepository<Transmission, Long> {
}
