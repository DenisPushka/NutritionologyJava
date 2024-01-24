package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.BiologicalElementRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MRItemRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MSRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MrRepositoryJPA;
import nutritionology.models.dictionaries.BiologicalElement;
import nutritionology.models.dictionaries.MR;
import nutritionology.models.dictionaries.MRItem;
import nutritionology.models.dictionaries.MS;
import nutritionology.services.interfaces.MRServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Репозиторий, реализующий логику для запросов к таблице "Методические рекомендации".
 */
@Service
public class MRService implements MRServiceInterface {

    /**
     * Реализатор запросов JPA для таблицы "Биологические элементы".
     */
    private BiologicalElementRepositoryJPA biologicalElementRepositoryJPA;

    /**
     * Реализатор запросов JPA для таблицы "Система измерений".
     */
    private MSRepositoryJPA msRepositoryJPA;

    /**
     * Реализатор запросов JPA для таблицы "Элемент МР".
     */
    private MRItemRepositoryJPA mrItemRepositoryJPA;

    /**
     * Реализатор запросов JPA для таблицы "Методические рекомендации".
     */
    private MrRepositoryJPA mrRepositoryJPA;

    public MRService(BiologicalElementRepositoryJPA biologicalElementRepositoryJPA
            , MSRepositoryJPA msRepositoryJPA, MRItemRepositoryJPA mrItemRepositoryJPA, MrRepositoryJPA mrRepositoryJPA) {
        this.biologicalElementRepositoryJPA = biologicalElementRepositoryJPA;
        this.msRepositoryJPA = msRepositoryJPA;
        this.mrItemRepositoryJPA = mrItemRepositoryJPA;
        this.mrRepositoryJPA = mrRepositoryJPA;
    }

    // region MS

    /**
     * Добавление СИ.
     *
     * @param ms Добавляемый объект.
     * @return Массив СИ.
     */
    @Override
    public MS[] addMs(MS ms) {
        msRepositoryJPA.save(ms);

        return getMSes();
    }

    /**
     * Добавление массива СИ.
     *
     * @param mses Добавляемые объекты.
     * @return Массив СИ.
     */
    @Override
    public MS[] addArrayMs(MS[] mses) {
        msRepositoryJPA.saveAll(Arrays.stream(mses).toList());

        return getMSes();
    }

    /**
     * Получение всех СИ.
     *
     * @return Массив СИ.
     */
    @Override
    public MS[] getMSes() {
        return msRepositoryJPA.findAll().toArray(new MS[0]);
    }

    // endregion

    // region Biologically element

    @Override
    public void addBiologicallyElement(BiologicalElement biologicalElement) {
        biologicalElementRepositoryJPA.save(biologicalElement);
    }

    /**
     * Получение всех биологических элементов.
     *
     * @return Массив биологических элементов.
     */
    @Override
    public BiologicalElement[] getBiologicallyElements() {
        return biologicalElementRepositoryJPA.findAll().toArray(new BiologicalElement[0]);
    }

    // endregion

    // region MR Item

    /**
     * Добавление элемента МР.
     *
     * @param mrItem Добавляемый объект.
     * @return Массив элементов МР.
     */
    @Override
    public MRItem[] addMrItem(MRItem mrItem) {
        mrItemRepositoryJPA.save(mrItem);

        return getAllMrItems();
    }

    /**
     * Добавление массива элементов МР.
     *
     * @param mrItems Добавляемые объекты.
     * @return Массив элементов МР.
     */
    @Override
    public MRItem[] addArrayMrItems(MRItem[] mrItems) {
        mrItemRepositoryJPA.saveAll(Arrays.stream(mrItems).toList());

        return getAllMrItems();
    }

    /**
     * Изменение элемента МР.
     *
     * @param mrItem Новоизменный объект.
     * @return Массив элементов МР.
     */
    @Override
    public MRItem[] updateMrItem(MRItem mrItem) {
        return addMrItem(mrItem);
    }

    /**
     * Получение элементов МР.
     *
     * @return Массив элементов МР.
     */
    @Override
    public MRItem[] getAllMrItems() {
        return mrItemRepositoryJPA.findAll().toArray(new MRItem[0]);
    }

    // endregion

    // region MR

    /**
     * Добавление МР.
     *
     * @param mr Добавляемый объект.
     * @return Массив МР.
     */
    @Override
    public MR[] addMr(MR mr) {
        mrRepositoryJPA.save(mr);

        return getAllMr();
    }

    /**
     * Добавление массива МР.
     *
     * @param mrs Добавляемые объекты.
     * @return Массив МР.
     */
    @Override
    public MR[] addMrs(MR[] mrs) {
        mrRepositoryJPA.saveAll(Arrays.stream(mrs).toList());

        return getAllMr();
    }

    /**
     * Изменение МР.
     *
     * @param mr Новоизмененный объект.
     * @return Массив МР.
     */
    @Override
    public MR[] updateMr(MR mr) {
        return addMr(mr);
    }

    /**
     * Получение массива МР.
     *
     * @return Массив МР.
     */
    @Override
    public MR[] getAllMr() {
        return mrRepositoryJPA.findAll().toArray(new MR[0]);
    }

    // endregion
}
