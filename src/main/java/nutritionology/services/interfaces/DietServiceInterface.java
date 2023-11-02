package nutritionology.services.interfaces;

import nutritionology.models.Diet;
import nutritionology.models.dictionaries.DayOfWeek;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.user.User;

/**
 * Интерфейс для запросов к таблице "Меню".
 * Включает запросы для таблиц: Прием пищи (MealTime), День недели (DayOfWeek).
 */
public interface DietServiceInterface {

    /**
     * Добавление рациона.
     *
     * @param diet Добавляемый рацион.
     * @return Массив рационов.
     */
    Diet[] AddDiet(Diet diet);

    /**
     * Добавление рациона пользователю.
     *
     * @param user Кому добавляется рацион.
     * @param diet Добавляемый рацион.
     * @return Добавленный рацион.
     */
    Diet AddDietToUser(User user, Diet diet);

    /**
     * Получение всех "Приемов пищи".
     *
     * @return Массив приемов пищи.
     */
    MealTime[] GetMealTimes();

    /**
     * Получение всех дней недели.
     *
     * @return Массив дней недели.
     */
    DayOfWeek[] GetAllDaysOdfWeek();
}
