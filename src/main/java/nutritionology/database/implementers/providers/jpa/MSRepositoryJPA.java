package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MSRepositoryJPA extends JpaRepository<MS, UUID> {
}
