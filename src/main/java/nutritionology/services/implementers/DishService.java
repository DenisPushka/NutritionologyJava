package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.driver.manager.DishImplementer;
import nutritionology.models.Dish;
import nutritionology.services.interfaces.DishServiceInterface;
import org.springframework.stereotype.Service;

/**
 * Сервис для блюд.
 */
@Service
public class DishService implements DishServiceInterface {

    /**
     * Репозиторий для блюда.
     */
    private DishImplementer dishImplementer;

    public DishService(DishImplementer dishImplementer) {
        this.dishImplementer = dishImplementer;
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
     * Получение массива блюд.
     *
     * @return Массив блюд.
     */
    @Override
    public Dish[] GetDishes() {
        return new Dish[0];
    }

    /**
     * Получение блюда по его имени.
     *
     * @param name название блюда.
     * @return Блюдо.
     */
    public Dish GetDishForName(String name) {
        return dishImplementer.GetDishForName(name);
    }
}
