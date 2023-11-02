package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DayOfWeekRepositoryJPA extends JpaRepository<DayOfWeek, UUID> {

}
