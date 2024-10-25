package kg.backend.meniki.repo;

import kg.backend.meniki.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByUsername(String username);
    Optional<User> getByEmail(String email);
    Optional<User> getUserByResetToken(String token);
}