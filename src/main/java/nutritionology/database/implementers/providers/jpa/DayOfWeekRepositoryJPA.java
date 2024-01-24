package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DayOfWeekRepositoryJPA extends JpaRepository<DayOfWeek, UUID> {

}
