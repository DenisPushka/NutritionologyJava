package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepositoryJPA extends JpaRepository<UserRole, UUID> {
}
