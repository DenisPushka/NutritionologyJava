package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivityRepositoryJPA extends JpaRepository<Activity, UUID> {
}
