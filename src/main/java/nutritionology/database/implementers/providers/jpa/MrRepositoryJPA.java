package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MrRepositoryJPA extends JpaRepository<MR, UUID> {
}
