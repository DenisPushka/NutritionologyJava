package nutritionology.services.interfaces;

import nutritionology.models.dictionaries.BiologicalElement;
import nutritionology.models.dictionaries.MR;
import nutritionology.models.dictionaries.MRItem;
import nutritionology.models.dictionaries.MS;

/**
 * Интерфейс для запросов к таблице "Методические рекомендации".
 * Включает запросы для таблиц: МР (MethodologicalRecommendation), элемент МР(MRItem),
 * СИ (MeasurementSystem) и биологического элемента (BiologicalElement).
 */
public interface MRServiceInterface {

    // region Система Исчеслений

    /**
     * Добавление СИ.
     *
     * @param ms Добавляемый объект.
     * @return Массив СИ.
     */
    MS[] AddMs(MS ms);

    /**
     * Добавление массива СИ.
     *
     * @param mses Добавляемые объекты.
     * @return Массив СИ.
     */
    MS[] AddArrayMs(MS[] mses);


    /**
     * Получение всех СИ.
     *
     * @return Массив СИ.
     */
    MS[] GetMSes();

    // endregion

    // region Биологический элемент


    /**
     * Получение всех биологических элементов.
     *
     * @return Массив биологических элементов.
     */
    BiologicalElement[] GetBiologicallyElements();

    // endregion

    // region Элемент методических рекомендаций

    /**
     * Добавление элемента МР.
     *
     * @param mrItem Добавляемый объект.
     * @return Массив элементов МР.
     */
    MRItem[] AddMrItem(MRItem mrItem);

    /**
     * Добавление массива элементов МР.
     *
     * @param mrItems Добавляемые объекты.
     * @return Массив элементов МР.
     */
    MRItem[] AddArrayMrItems(MRItem[] mrItems);

    /**
     * Изменение элемента МР.
     *
     * @param mrItem Новоизменный объект.
     * @return Массив элементов МР.
     */
    MRItem[] UpdateMrItem(MRItem mrItem);

    /**
     * Получение элементов МР.
     *
     * @return Массив элементов МР.
     */
    MRItem[] GetAllMrItems();

    // endregion

    // region Методические рекомендации (МР)

    /**
     * Добавление МР.
     *
     * @param mr Добавляемый объект.
     * @return Массив МР.
     */
    MR[] AddMr(MR mr);

    /**
     * Добавление массива МР.
     *
     * @param mrs Добавляемые объекты.
     * @return Массив МР.
     */
    MR[] AddMrs(MR[] mrs);

    /**
     * Изменение МР.
     *
     * @param mr Новоизмененный объект.
     * @return Массив МР.
     */
    MR[] UpdateMr(MR mr);

    /**
     * Получение массива МР.
     *
     * @return Массив МР.
     */
    MR[] GetAllMr();

    // endregion
}
