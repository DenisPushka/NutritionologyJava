package nutritionology.services.interfaces;

import nutritionology.models.Dish;
import org.springframework.stereotype.Service;

/**
 * Интерфейс для запросов к таблице "Блюдо" (Dish), рецепт (Recipe) и продукт блюдо Мап.
 */
@Service
public interface DishServiceInterface {

    /**
     * Добавление блюда.
     *
     * @param dish Блюдо.
     * @return Добавленное блюдо.
     */
    Dish addDish(Dish dish);

    /**
     * Получение массива блюд.
     *
     * @return Массив блюд.
     */
    Dish[] getDishes();

    /// <summary>
    /// Получение блюда по <paramref name="dishId"/>.
    /// </summary>
    /// <param name="dishId">Id блюда.</param>
    /// <returns>Блюдо.</returns>
    // Task<Dish> GetDish(Guid dishId);

    /**
     * Получение блюда по миени
     *
     * @param name Название блюда.
     * @return Искомое блюдо.
     */
    Dish getDishForName(String name);
}
