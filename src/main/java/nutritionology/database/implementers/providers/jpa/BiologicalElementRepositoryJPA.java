package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.BiologicalElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BiologicalElementRepositoryJPA extends JpaRepository<BiologicalElement, UUID> {
}
