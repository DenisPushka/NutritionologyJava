package nutritionology.services;

import nutritionology.database.implementers.providers.jpa.*;
import nutritionology.database.models.Tuple2;
import nutritionology.models.Diet;
import nutritionology.models.Dish;
import nutritionology.models.Parameter;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.maps.DietDish;
import nutritionology.models.maps.ProductDish;
import nutritionology.models.maps.ProductMRItem;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

/**
 * Создатель меню.
 *
 * @Date 07.01.2024
 */
@Service
public class CreatorMenu {

    private final Logger log = Logger.getLogger(CreatorMenu.class.getName());

    /**
     * Служит для передачи условия в параметр.
     */
    public interface ParamFunctionInterface {

        /**
         * Проверяльщик условия между МР пользователя и МР блюда.
         *
         * @param bufferForDish МР блюда.
         * @param tuple         МР пользователя.
         * @return <b>True</b> в случае <u>НЕ</u> прохождения.
         */
        boolean checkLogicBetweenMRAndDish(HashMap<String, Double> bufferForDish, Tuple2<String, Double> tuple);
    }

    //    private boolean checkLogicBetweenMRAndDish(HashMap<String, Double> bufferForDish, Tuple2<String, Double> tuple) {
    /**
     * Условие проверки между МР пользователя и МР блюда.
     */
    private final ParamFunctionInterface checkLogicBetweenMRAndDish = (bufferForDish, tuple) -> !(
            bufferForDish.containsKey(tuple.getFirst())
                    && bufferForDish.get(tuple.getFirst()) >= tuple.getSecond()
                    && !(
                    tuple.getFirst().equals("Белок")
                            || tuple.getFirst().equals("Жир")
                            || tuple.getFirst().equals("Калории")
                            || tuple.getFirst().equals("Углеводы"))
    );

    /**
     * Условие проверки между МР пользователя и МР блюда только по КБЖУ.
     */
    private final ParamFunctionInterface checkLogicBetweenMRAndDishOnlyPPFC = (bufferForDish, tuple) -> !(
            (
                    tuple.getFirst().equals("Белок")
                            || tuple.getFirst().equals("Жир")
                            || tuple.getFirst().equals("Калории")
                            || tuple.getFirst().equals("Углеводы")
            )

                    && bufferForDish.containsKey(tuple.getFirst())
                    && bufferForDish.get(tuple.getFirst()) <= tuple.getSecond()
    );

    private final MrRepositoryJPA mrRepositoryJPA;
    private final ActivityRepositoryJPA activityRepositoryJPA;
    private final DishRepositoryJPA dishRepositoryJPA;
    private final DietRepositoryJPA dietRepositoryJPA;
    private final DietDishRepositoryJPA dietDishRepositoryJPA;
    private final MealTimeRepositoryJPA mealTimeRepositoryJPA;

    public CreatorMenu(MrRepositoryJPA mrRepositoryJPA, ActivityRepositoryJPA activityRepositoryJPA, DishRepositoryJPA dishRepositoryJPA, DietRepositoryJPA dietRepositoryJPA, DietDishRepositoryJPA dietDishRepositoryJPA, MealTimeRepositoryJPA mealTimeRepositoryJPA) {
        this.mrRepositoryJPA = mrRepositoryJPA;
        this.activityRepositoryJPA = activityRepositoryJPA;
        this.dishRepositoryJPA = dishRepositoryJPA;
        this.dietRepositoryJPA = dietRepositoryJPA;
        this.dietDishRepositoryJPA = dietDishRepositoryJPA;
        this.mealTimeRepositoryJPA = mealTimeRepositoryJPA;
    }

    /**
     * Создание рациона для 1 дня.
     *
     * @param parameter Параметр пользователя.
     */
    public void CreateMenuToOneDay(Parameter parameter) {
        log.info("Create menu to one day");

        //region 1. Получение начального набора данных по полу и возрасту.

        List<Object[]> mrsFromAgeAndGender = mrRepositoryJPA.GetDataFromPerson((int) parameter.getAge(), "Ж");
        List<Tuple2<String, Double>> mrs = new ArrayList<>();
//        HashMap<String, Double> mrs = new HashMap<>();

        for (Object[] objs : mrsFromAgeAndGender) {
            Tuple2<String, Double> mr = new Tuple2<>();
            mr.setFirst((String) objs[0]);
            mr.setSecond((Double) objs[1]);

            mrs.add(mr);
//            mrs.put((String) objs[0], (Double) objs[1]);
        }

        //endregion

        //region 2. Получение данных по коэф. физической активности.

        List<Object[]> mrsFromActivity = activityRepositoryJPA.GetPPFCFromActivity((int) parameter.getAge(), "2", "5675D50D-35F7-4708-81B3-2AA6152F799D");

        Tuple2<String, Double> mrP = new Tuple2("Калории", mrsFromActivity.get(0)[0]);
        Tuple2<String, Double> mrPr = new Tuple2("Белок", mrsFromActivity.get(0)[1]);
        Tuple2<String, Double> mrF = new Tuple2("Жир", mrsFromActivity.get(0)[2]);
        Tuple2<String, Double> mrC = new Tuple2("Углеводы", mrsFromActivity.get(0)[3]);

        mrs.add(mrP);
        mrs.add(mrPr);
        mrs.add(mrF);
        mrs.add(mrC);
//        mrs.put("Калории", (Double) mrsFromActivity.get(0)[0]);
//        mrs.put("Белок", (Double) mrsFromActivity.get(0)[1]);
//        mrs.put("Жир", (Double) mrsFromActivity.get(0)[2]);
//        mrs.put("Углеводы", (Double) mrsFromActivity.get(0)[3]);

        //endregion

        //region 3. Расчет ИМТ.

//        var IMB = parameter.Weight / (parameter.Height * parameter.Height);
        // todo доделать логику.
        //endregion

        //region 4. Цель.

        // Данный параметр должен быть определен.

        //endregion

        //region 5. Количество приемов пищи.

        float[] pfc = percentPowerOnEverMealTime(parameter.getCountMealTimeInDay());

        //endregion

        List<MealTime> mealTimes = new ArrayList<>();
        MealTime mealTimeBreakfast = mealTimeRepositoryJPA.findFirstByName("Завтрак");
        MealTime mealTimeDinner = mealTimeRepositoryJPA.findFirstByName("Ужин");

        mealTimes.add(mealTimeBreakfast);
        mealTimes.add(mealTimeDinner);

        List<Dish> breakfasts = dishRepositoryJPA.findDishesByMealTimes(mealTimeBreakfast);
        List<Dish> dinners = dishRepositoryJPA.findDishesByMealTimes(mealTimeDinner);

        List<Dish> launches = null;
        List<Dish> launches2 = null;
        List<Dish> dinners2 = null;

        // region Заполнение mrs для каждого приема пищи в зависимости от их количества.
        Tuple2<String, Double>[] mrsArrayMain = mrs.toArray(new Tuple2[0]);
        Tuple2<String, Double>[] mrsArrayForBreakfast = cloneArray(mrsArrayMain);
        Tuple2<String, Double>[] mrsArrayForDinner = cloneArray(mrsArrayMain);
        Tuple2<String, Double>[] mrsArrayForLaunch = null;
        Tuple2<String, Double>[] mrsArrayForLaunch2 = null;
        Tuple2<String, Double>[] mrsArrayForDinner2 = null;

        List<Tuple2<String, Double>[]> listArraysTuple = new ArrayList<>();
        listArraysTuple.add(mrsArrayForBreakfast);
        listArraysTuple.add(mrsArrayForDinner);

        if (parameter.getCountMealTimeInDay() > 2) {
            mrsArrayForLaunch = cloneArray(mrsArrayMain);
            listArraysTuple.add(mrsArrayForLaunch);
            MealTime mealTimeLaunch = mealTimeRepositoryJPA.findFirstByName("Обед");
            launches = dishRepositoryJPA.findDishesByMealTimes(mealTimeLaunch);
            mealTimes.add(mealTimeLaunch);
        }
        if (parameter.getCountMealTimeInDay() > 3) {
            mrsArrayForLaunch2 = cloneArray(mrsArrayMain);
            listArraysTuple.add(mrsArrayForLaunch2);
            MealTime mealTimeLaunch2 = mealTimeRepositoryJPA.findFirstByName("Полдник");
            launches2 = dishRepositoryJPA.findDishesByMealTimes(mealTimeLaunch2);
            mealTimes.add(mealTimeLaunch2);
        }
        if (parameter.getCountMealTimeInDay() > 4) {
            mrsArrayForDinner2 = cloneArray(mrsArrayMain);
            listArraysTuple.add(mrsArrayForDinner2);
            MealTime mealTimeDinner2 = mealTimeRepositoryJPA.findFirstByName("Сонник");
            dinners2 = dishRepositoryJPA.findDishesByMealTimes(mealTimeDinner2);
            mealTimes.add(mealTimeDinner2);
        }

        for (int i = 0; i < pfc.length; i++) {
            updateMRsArrayForMealTime(listArraysTuple.get(i), pfc, i);
        }

        // endregion

        // region Получение блюд по каждому приему пищи.
        Dish resultBreakfast = searchBestDishForMealTime(breakfasts, mrsArrayForBreakfast, checkLogicBetweenMRAndDish);
        Dish resultDinner = searchBestDishForMealTime(dinners, mrsArrayForDinner, checkLogicBetweenMRAndDish);
        Dish resultLaunch;
        Dish resultLaunch2;
        Dish resultDinner2;

        Dish[] dishes = new Dish[parameter.getCountMealTimeInDay()];
        dishes[0] = resultBreakfast;
        dishes[dishes.length - 1] = resultDinner;

        if (parameter.getCountMealTimeInDay() > 2) {
            resultLaunch = searchBestDishForMealTime(launches, mrsArrayForDinner, checkLogicBetweenMRAndDish);
            dishes[1] = resultLaunch;
        }
        if (parameter.getCountMealTimeInDay() > 3) {
            resultLaunch2 = searchBestDishForMealTime(launches2, mrsArrayForDinner, checkLogicBetweenMRAndDish);
            dishes[2] = resultLaunch2;
        }
        if (parameter.getCountMealTimeInDay() > 4) {
            resultDinner2 = searchBestDishForMealTime(dinners2, mrsArrayForDinner, checkLogicBetweenMRAndDish);
            dishes[3] = resultDinner2;
        }

        // endregion

        // Обращение в репу для сохранения всех изменений.
        // todo лучше все это вынести в отдельный мкс.

        saveAllDifference(dishes, mealTimes.toArray(new MealTime[0]));

        var stop = 0;
    }


    /**
     * Сохранение всех изменений в БД.
     *
     * @param dishes    Блюда.
     * @param mealTimes Приемы пищи.
     */
    public void saveAllDifference(Dish[] dishes, MealTime[] mealTimes) {
        if (dishes.length != mealTimes.length) {
            return;
        }

        // todo Задачи:
        // 1. Добавить блюда (по каждому приему пищи, как минимум 5 штук).✅
        // 2. Протестировать выборку.✅
        // 3. Нарисовать UI для отображения выборки.✅
        // 4. Прокинуть запрос с рационом.✅
        // 5. Нарисовать конструктор для создания блюд.✅
        // 6. Прокинуть запросы на сохранения созданных пользователем блюд.✅
        // 7. Сделать UI для меню на фронте.✅
        // 8. Добавить фото к блюдам.✅
        // 9. Отладить правильность выборки.

        Diet diet = new Diet();
        diet = dietRepositoryJPA.save(diet);

        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null) {
                dietDishRepositoryJPA.save(
                        DietDish
                                .builder()
                                .dish(dishes[i])
                                .diet(diet)
                                .mealTime(mealTimes[i])
                                .numberWeek(1)
                                .build()
                );
            }
        }
    }


    /**
     * Поиск лучшего блюда для приема пищи.
     *
     * @param dishList Список блюд.
     * @param method   Условие проверки между МР пользователем и МР блюда.
     * @param mrs      МР пользователя.
     * @return Подходящее блюдо.
     */
    public Dish searchBestDishForMealTime(List<Dish> dishList, Tuple2<String, Double>[] mrs, ParamFunctionInterface method) {
        Dish dishResult;

        // Беру блюда.
        for (Dish dish : dishList) {
            Set<ProductDish> productDishes = dish.getProductDishes();
            HashMap<String, Double> bufferForDish = new HashMap<>();

            // Продукты.
            calculateNutrientsInDish(productDishes, bufferForDish);

            dishResult = dish;
            boolean isChoice = true;

            // Проверка между МР пользователя и МР блюда.
            for (Tuple2<String, Double> tuple : mrs) {
                if (method.checkLogicBetweenMRAndDish(bufferForDish, tuple)) {
                    dishResult = null;
                    isChoice = false;
                    break;
                }
            }

            // Успешная проверка.
            if (isChoice) return dishResult;
        }

        // При ненахождении необходимого блюда вообще.
        if (method.equals(checkLogicBetweenMRAndDishOnlyPPFC)) {
            // todo зарандомить выбор.
            return dishList.get(1);
        }

        // Вызов этой же ф-ии ток для КБЖУ.
        return searchBestDishForMealTime(dishList, mrs, checkLogicBetweenMRAndDishOnlyPPFC);
    }

    /**
     * Высчитывание всех нутриентов в блюде.
     *
     * @param bufferForDish Буфер, в который будет класться результат.
     * @param productDishes Продукты блюда.
     */
    public static void calculateNutrientsInDish(Set<ProductDish> productDishes, HashMap<String, Double> bufferForDish) {
        for (ProductDish productDish : productDishes) {
            Set<ProductMRItem> productMRItems = productDish.getProduct().getProductMRItems();

            // МР продукта.
            for (ProductMRItem productMRItem : productMRItems) {
                // Если не встречался, создаем в буфере данную позицию.
                if (!bufferForDish.containsKey(productMRItem.getMrItem().getName())) {
                    bufferForDish.put(productMRItem.getMrItem().getName(), 0.0);
                }

                bufferForDish.put(productMRItem.getMrItem().getName(),
                        bufferForDish.get(productMRItem.getMrItem().getName()) + productMRItem.getFoodValue());
            }
        }
    }

    /**
     * Обновление значений МР для определенного приема питания.
     */
    private void updateMRsArrayForMealTime(Tuple2<String, Double>[] mrs, float[] pfc, int indexPFC) {
        for (Tuple2<String, Double> tuple : mrs) {
            tuple.setSecond(tuple.getSecond() * pfc[indexPFC]);
        }
    }

    /**
     * Расчет процентного содержания калорий при приеме пищи в зависимости от их кол-ва.
     *
     * @param countMealTime Кол-во приемов пищи.
     */
    private float[] percentPowerOnEverMealTime(int countMealTime) {
        float[] pfc = new float[countMealTime];

        switch (countMealTime) {
            case 2 -> {
                pfc[0] = 0.5f;
                pfc[1] = 0.5f;
            }
            case 3 -> {
                pfc[0] = 0.3f;
                pfc[1] = 0.4f;
                pfc[2] = 0.4f;
            }
            case 4 -> {
                pfc[0] = 0.25f;
                pfc[1] = 0.4f;
                pfc[2] = 0.15f;
                pfc[3] = 0.2f;
            }
            case 5 -> {
                pfc[0] = 0.25f;
                pfc[1] = 0.1f;
                pfc[2] = 0.35f;
                pfc[3] = 0.1f;
                pfc[4] = 0.2f;
            }
            default -> {
            }
        }

        return pfc;
    }

    /**
     * Клонирование массива МР пользователя для каждого приема пищи.
     */
    private Tuple2<String, Double>[] cloneArray(Tuple2<String, Double>[] mrsArrayMain) {
        Tuple2<String, Double>[] buffer = new Tuple2[mrsArrayMain.length];

        try {
            for (int i = 0; i < mrsArrayMain.length; i++) {
                buffer[i] = mrsArrayMain[i].clone();
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        return buffer;
    }
}
