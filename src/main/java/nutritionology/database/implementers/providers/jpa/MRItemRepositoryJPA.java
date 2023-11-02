package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MR;
import nutritionology.models.dictionaries.MRItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MRItemRepositoryJPA extends JpaRepository<MRItem, UUID> {
}
