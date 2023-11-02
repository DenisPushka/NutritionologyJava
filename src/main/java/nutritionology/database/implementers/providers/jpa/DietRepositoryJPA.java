package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DietRepositoryJPA extends JpaRepository<Diet, UUID> {
}
