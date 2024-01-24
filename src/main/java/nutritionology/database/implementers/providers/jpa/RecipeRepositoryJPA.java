package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Date 14.01.2024
 */
@Repository
public interface RecipeRepositoryJPA extends JpaRepository<Recipe, UUID> {

    Recipe getRecipeByDescription(String description);
}
