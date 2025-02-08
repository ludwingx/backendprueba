package posCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posCarRental.entity.User;

import java.util.Optional;

@Repository
public interface IUserRepository  extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);
}
