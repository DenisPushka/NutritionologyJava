package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.BiologicalElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BiologicalElementRepositoryJPA extends JpaRepository<BiologicalElement, UUID> {
}
