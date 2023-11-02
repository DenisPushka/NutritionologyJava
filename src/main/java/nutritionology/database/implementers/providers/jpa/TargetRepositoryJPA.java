package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TargetRepositoryJPA extends JpaRepository<Target, UUID> {
}
