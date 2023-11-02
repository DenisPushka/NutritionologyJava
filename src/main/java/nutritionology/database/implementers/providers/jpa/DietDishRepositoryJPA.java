package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Gender;
import nutritionology.models.maps.DietDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DietDishRepositoryJPA extends JpaRepository<DietDish, UUID> {
}
