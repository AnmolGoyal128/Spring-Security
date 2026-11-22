package in.springBoot.SpringPracticalDemo.repository;

import in.springBoot.SpringPracticalDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // method
    Optional<User> findByUsername(String username);
}
