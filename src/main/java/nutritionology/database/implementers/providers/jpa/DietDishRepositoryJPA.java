package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.maps.DietDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DietDishRepositoryJPA extends JpaRepository<DietDish, UUID> {
}
