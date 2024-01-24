package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MSRepositoryJPA extends JpaRepository<MS, UUID> {
}
