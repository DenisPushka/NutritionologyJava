package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DietRepositoryJPA extends JpaRepository<Diet, UUID> {
}
