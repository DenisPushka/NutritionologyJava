package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.driver.manager.DishImplementer;
import nutritionology.database.implementers.providers.jpa.DishRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MSRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.ProductDishRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.TypeLunchRepository;
import nutritionology.models.Dish;
import nutritionology.models.maps.ProductDish;
import nutritionology.models.maps.ProductDishKey;
import nutritionology.models.maps.ProductMRItem;
import nutritionology.services.interfaces.DishServiceInterface;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

/**
 * Сервис для блюд.
 */
@Service
public class DishService implements DishServiceInterface {

    /**
     * Репозиторий для блюда.
     */
    private final DishImplementer dishImplementer;

    private final DishRepositoryJPA dishRepositoryJPA;
    private final ProductService productService;
    private final RecipeService recipeService;
    private final ProductDishRepositoryJPA productDishRepositoryJPA;
    private final TypeLunchRepository typeLunchRepository;
    private final MSRepositoryJPA msRepositoryJPA;


    public DishService(DishImplementer dishImplementer, DishRepositoryJPA dishRepositoryJPA,
                       ProductService productService, RecipeService recipeService,
                       ProductDishRepositoryJPA productDishRepositoryJPA, TypeLunchRepository typeLunchRepository, MSRepositoryJPA msRepositoryJPA) {
        this.dishImplementer = dishImplementer;
        this.dishRepositoryJPA = dishRepositoryJPA;
        this.productService = productService;
        this.recipeService = recipeService;
        this.productDishRepositoryJPA = productDishRepositoryJPA;
        this.typeLunchRepository = typeLunchRepository;
        this.msRepositoryJPA = msRepositoryJPA;
    }

    /**
     * Добавление блюда.
     *
     * @param dish Блюдо.
     * @return Добавленное блюдо.
     */
    @Override
    public Dish addDish(Dish dish) {
        double weight = 0;

        for (ProductDish productDish : dish.getProductDishes()) {
            productDish.setProduct(productService.addProduct(productDish.getProduct()));
            productDish.setMs(msRepositoryJPA.getFirstByShortName(productDish.getMs().getShortName()));

            weight += productDish.getWeight();
        }

        // region Validation on recipe and type lunch

        if (dish.getRecipe().getDescription().trim().length() != 0){
            dish.setRecipe(recipeService.addRecipe(dish.getRecipe()));
        } else {
            dish.setRecipe(null);
        }

        if (dish.getTypeLunch().getName() == null) {
            dish.setTypeLunch(typeLunchRepository.getTypeLunchByName(" "));
        }

        // endregion

        dish.setWeight(weight);
        dishRepositoryJPA.save(dish);

        Dish currentDish = dishRepositoryJPA.findFirstByName(dish.getName());

        for (ProductDish product : dish.getProductDishes()) {
            product.setDish(currentDish);
            product.setProductDishId(new ProductDishKey(product.getProduct().getProductId(), currentDish.getDishId()));

            productDishRepositoryJPA.save(product);
        }

        return currentDish;
    }

    /**
     * Получение массива блюд.
     *
     * @return Массив блюд.
     */
    @Override
    public Dish[] getDishes() {
        return dishRepositoryJPA.findAll().toArray(new Dish[0]);
    }

    /**
     * Получение блюда по его имени.
     *
     * @param name название блюда.
     * @return Блюдо.
     */
    public Dish getDishForName(String name) {
        return dishRepositoryJPA.findFirstByName(name);
    }
}
