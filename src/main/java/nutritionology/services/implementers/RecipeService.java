package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.RecipeRepositoryJPA;
import nutritionology.models.Recipe;
import nutritionology.services.interfaces.RecipeServiceInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Date 14.01.2024
 */
@Service
public class RecipeService implements RecipeServiceInterface {

    private final RecipeRepositoryJPA recipeRepositoryJPA;

    public RecipeService(RecipeRepositoryJPA recipeRepositoryJPA) {
        this.recipeRepositoryJPA = recipeRepositoryJPA;
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        Recipe current = recipeRepositoryJPA.getRecipeByDescription(recipe.getDescription());
        if (current != null){
            return getRecipe(current.getRecipeId());
        }

        recipeRepositoryJPA.save(recipe);
        return recipeRepositoryJPA.getRecipeByDescription(recipe.getDescription());
    }

    @Override
    public Recipe getRecipe(UUID uuid) {
        return recipeRepositoryJPA.findById(uuid).get();
    }

    public Recipe getRecipeForDescription(String descr) {return recipeRepositoryJPA.getRecipeByDescription(descr);}
}
