package nutritionology.services.interfaces;

import nutritionology.models.Dish;

/**
 * Интерфейс для запросов к таблице "Блюдо" (Dish), рецепт (Recipe) и продукт блюдо Мап.
 */
public interface DishServiceInterface {

    /**
     * Добавление блюда.
     *
     * @param dish Блюдо.
     * @return Добавленное блюдо.
     */
    Dish AddDish(Dish dish);

    /**
     * Получение массива блюд.
     *
     * @return Массив блюд.
     */
    Dish[] GetDishes();

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
    Dish GetDishForName(String name);
}
