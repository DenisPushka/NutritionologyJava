package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.driver.manager.DishImplementer;
import nutritionology.database.implementers.providers.jpa.DishRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.ProductDishRepositoryJPA;
import nutritionology.models.Dish;
import nutritionology.models.maps.ProductDish;
import nutritionology.models.maps.ProductDishKey;
import nutritionology.services.interfaces.DishServiceInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

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


    public DishService(DishImplementer dishImplementer, DishRepositoryJPA dishRepositoryJPA,
                       ProductService productService, RecipeService recipeService,
                       ProductDishRepositoryJPA productDishRepositoryJPA) {
        this.dishImplementer = dishImplementer;
        this.dishRepositoryJPA = dishRepositoryJPA;
        this.productService = productService;
        this.recipeService = recipeService;
        this.productDishRepositoryJPA = productDishRepositoryJPA;
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

        for (ProductDish product : dish.getProductDishes()) {
            product.setProduct(productService.addProduct(product.getProduct()));

            weight += product.getWeight();
        }

        dish.setWeight(weight);
        dish.setRecipe(recipeService.addRecipe(dish.getRecipe()));
        dishRepositoryJPA.save(dish);

        Dish currentDish = dishRepositoryJPA.findFirstByName(dish.getName());

        for (ProductDish product : dish.getProductDishes()) {
            product.setProduct(productService.addProduct(product.getProduct()));

            ProductDish productDish = new ProductDish();
            productDish.setDish(currentDish);
            productDish.setProduct(product.getProduct());
            productDish.setMs(product.getMs());

            productDish.setProductDishId(new ProductDishKey(product.getProduct().getProductId(), currentDish.getDishId()));

            productDishRepositoryJPA.save(productDish);
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
        return new Dish[0];
    }

    /**
     * Получение блюда по его имени.
     *
     * @param name название блюда.
     * @return Блюдо.
     */
    public Dish getDishForName(String name) {
        return dishImplementer.getDishForName(name);
    }
}
