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
    MS[] addMs(MS ms);

    /**
     * Добавление массива СИ.
     *
     * @param mses Добавляемые объекты.
     * @return Массив СИ.
     */
    MS[] addArrayMs(MS[] mses);


    /**
     * Получение всех СИ.
     *
     * @return Массив СИ.
     */
    MS[] getMSes();

    // endregion

    // region Биологический элемент

    void addBiologicallyElement(BiologicalElement biologicalElement);
    /**
     * Получение всех биологических элементов.
     *
     * @return Массив биологических элементов.
     */
    BiologicalElement[] getBiologicallyElements();

    // endregion

    // region Элемент методических рекомендаций

    /**
     * Добавление элемента МР.
     *
     * @param mrItem Добавляемый объект.
     * @return Массив элементов МР.
     */
    MRItem[] addMrItem(MRItem mrItem);

    /**
     * Добавление массива элементов МР.
     *
     * @param mrItems Добавляемые объекты.
     * @return Массив элементов МР.
     */
    MRItem[] addArrayMrItems(MRItem[] mrItems);

    /**
     * Изменение элемента МР.
     *
     * @param mrItem Новоизменный объект.
     * @return Массив элементов МР.
     */
    MRItem[] updateMrItem(MRItem mrItem);

    /**
     * Получение элементов МР.
     *
     * @return Массив элементов МР.
     */
    MRItem[] getAllMrItems();

    // endregion

    // region Методические рекомендации (МР)

    /**
     * Добавление МР.
     *
     * @param mr Добавляемый объект.
     * @return Массив МР.
     */
    MR[] addMr(MR mr);

    /**
     * Добавление массива МР.
     *
     * @param mrs Добавляемые объекты.
     * @return Массив МР.
     */
    MR[] addMrs(MR[] mrs);

    /**
     * Изменение МР.
     *
     * @param mr Новоизмененный объект.
     * @return Массив МР.
     */
    MR[] updateMr(MR mr);

    /**
     * Получение массива МР.
     *
     * @return Массив МР.
     */
    MR[] getAllMr();

    // endregion
}
