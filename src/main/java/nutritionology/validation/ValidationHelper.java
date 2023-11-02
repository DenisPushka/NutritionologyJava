package nutritionology.validation;

import java.util.UUID;

/**
 * Валидатор.
 */
public class ValidationHelper {

    /**
     * Проверка строки на пустоту и пробелы.
     *
     * @param text Проверяемая строка.
     */
    public static void CheckString(String text) {
        if (text == null || text.isEmpty() || text.isBlank()) {
            throw new IllegalArgumentException("Передана пустая строка!");
        }
    }

    /**
     * Проверка объекта на null.
     *
     * @param obj Проверяемый объект.
     */
    public static void CheckObject(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Передан null!");
        }
    }

    /**
     * Проверка UUID на дефолтное значение.
     *
     * @param id Проверяемый UUID.
     */
    public static void CheckGuid(UUID id) {
        CheckString(id.toString());

        if (id.equals(new UUID(0, 0))) {
            throw new IllegalArgumentException("Передан пустой uuid!");
        }
    }

    /**
     * Проверка значения на отрезке [start..finish].
     *
     * @param start      Начало отрезка.
     * @param finish     Конец отрезка
     * @param checkValue Проверямое значение.
     */
    public static void CheckNumber(double start, double finish, double checkValue) {
        if (checkValue < start || start > finish) {
            throw new IllegalArgumentException("Число не входит в отрезок!");
        }
    }
}
