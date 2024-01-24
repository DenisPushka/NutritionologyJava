package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Dish;
import nutritionology.models.dictionaries.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepositoryJPA extends JpaRepository<Dish, UUID> {

    List<Dish> findDishesByMealTimes(MealTime mealTime);

   Dish findFirstByName(String name);
}
