package nutritionology.services.interfaces;

import nutritionology.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Date 14.01.2024
 */
@Service
public interface RecipeServiceInterface {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(UUID uuid);
}
