package nutritionology.services.interfaces;

import nutritionology.models.Diet;
import nutritionology.models.dictionaries.DayOfWeek;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.user.User;

import java.util.UUID;

/**
 * Интерфейс для запросов к таблице "Меню".
 * Включает запросы для таблиц: Прием пищи (MealTime), День недели (DayOfWeek).
 */
public interface DietServiceInterface {

    /**
     * Получение всех "Приемов пищи".
     *
     * @return Массив приемов пищи.
     */
    MealTime[] getMealTimes();

    /**
     * Получение всех дней недели.
     *
     * @return Массив дней недели.
     */
    DayOfWeek[] getAllDaysOdfWeek();

    /**
     * Получение рациона по id.
     *
     * @param uuid Id рациона.
     */
    Diet getDietById(String uuid);
}
