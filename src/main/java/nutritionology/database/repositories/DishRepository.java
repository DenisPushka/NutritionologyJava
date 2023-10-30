package nutritionology.database.repositories;

import nutritionology.database.implementers.providers.driver.manager.DishImplementer;
//import com.database.implementers.providers.jpa.DishRepositoryJpa;
import nutritionology.models.Dish;
import nutritionology.database.interfaces.DishRepositoryInterface;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для запросов к таблице "Блюдо" (Dish), СИ (MS), рецепт (Recipe) и продукт блюдо Мап.
 */
@Repository
public class DishRepository implements DishRepositoryInterface {

    /**
     * Реализатор запросов при помощи драйвера.
     */
    private DishImplementer dishImplementer;

    /**
     * Реализатор запросов при помощи JPA.
     */
//    private DishRepositoryJpa dishRepositoryJpa;
    public DishRepository(DishImplementer dishImplementer/*, DishRepositoryJpa dishRepositoryJpa*/) {
        this.dishImplementer = dishImplementer;
//        this.dishRepositoryJpa = dishRepositoryJpa;
    }

    /**
     * Добавление блюда.
     *
     * @param dish Блюдо.
     * @return Добавленное блюдо.
     */
    @Override
    public Dish AddDish(Dish dish) {
        return null;
    }

    /**
     * Получение блюда по миени
     *
     * @param name Название блюда.
     * @return Искомое блюдо.
     */
    @Override
    public Dish GetDishForName(String name) {
        return dishImplementer.GetDishForName(name);
    }
}
