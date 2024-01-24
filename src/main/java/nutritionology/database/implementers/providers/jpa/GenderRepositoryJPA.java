package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenderRepositoryJPA extends JpaRepository<Gender, UUID> {
    UUID findFirstByShortName(String name);
}
