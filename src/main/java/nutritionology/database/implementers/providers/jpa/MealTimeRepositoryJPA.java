package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealTimeRepositoryJPA extends JpaRepository<MealTime, UUID> {
}
