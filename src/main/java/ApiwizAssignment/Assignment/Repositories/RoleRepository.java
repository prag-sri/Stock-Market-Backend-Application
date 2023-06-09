package ApiwizAssignment.Assignment.Repositories;

import ApiwizAssignment.Assignment.Entities.UserRole;
import ApiwizAssignment.Assignment.Entities.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {
    Optional<Role> findByName(UserRole role);
}
