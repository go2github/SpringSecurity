package SpringSecuritySpringData.user.repo;

import SpringSecuritySpringData.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);
    Optional<User> findByUsername(String username);
}
