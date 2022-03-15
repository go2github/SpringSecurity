package SpringSecuritySpringData.user.repo;

import SpringSecuritySpringData.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
