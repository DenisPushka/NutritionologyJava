package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<User, UUID> {
}
