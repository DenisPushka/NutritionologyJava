package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MealTimeRepositoryJPA extends JpaRepository<MealTime, UUID> {

    MealTime findFirstByName(String name);
}
