package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenderRepositoryJPA extends JpaRepository<Gender, UUID> {
}
