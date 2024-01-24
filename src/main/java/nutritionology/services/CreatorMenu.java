package nutritionology.services;

import nutritionology.database.implementers.providers.jpa.ActivityRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.DishRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MealTimeRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MrRepositoryJPA;
import nutritionology.database.models.Tuple2;
import nutritionology.models.Dish;
import nutritionology.models.Parameter;
import nutritionology.models.maps.ProductDish;
import nutritionology.models.maps.ProductMRItem;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Создавальщик меню.
 *
 * @Date 07.01.2024
 */
@Service
public class CreatorMenu {

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
    private ParamFunctionInterface checkLogicBetweenMRAndDish = (bufferForDish, tuple) -> !(
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
    private ParamFunctionInterface checkLogicBetweenMRAndDishOnlyPPFC = (bufferForDish, tuple) -> !(
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
    private final MealTimeRepositoryJPA mealTimeRepositoryJPA;

    public CreatorMenu(MrRepositoryJPA mrRepositoryJPA, ActivityRepositoryJPA activityRepositoryJPA, DishRepositoryJPA dishRepositoryJPA, MealTimeRepositoryJPA mealTimeRepositoryJPA) {
        this.mrRepositoryJPA = mrRepositoryJPA;
        this.activityRepositoryJPA = activityRepositoryJPA;
        this.dishRepositoryJPA = dishRepositoryJPA;
        this.mealTimeRepositoryJPA = mealTimeRepositoryJPA;
    }

    /**
     * Создание рациона для 1 дня.
     *
     * @param parameter Параметр пользователя.
     */
    public void CreateMenuToOneDay(Parameter parameter) {
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

        // 1. Склеить данные п.1 + п.2
        // 2. Обработать данные по цели и кол-ву приемов пищи
        // 3. Начать поиск блюда по данным из п.2 (начать с завтрака)
        // 4. По кол-ву приемов пищи находить блюда

        List<Dish> breakfasts = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Завтрак"));
        List<Dish> dinners = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Ужин"));
        List<Dish> launches = null;
        List<Dish> launches2 = null;
        List<Dish> dinners2 = null;

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
            launches = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Обед"));
        }
        if (parameter.getCountMealTimeInDay() > 3) {
            mrsArrayForLaunch2 = cloneArray(mrsArrayMain);
            listArraysTuple.add(mrsArrayForLaunch2);
            launches2 = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Полдник"));
        }
        if (parameter.getCountMealTimeInDay() > 4) {
            mrsArrayForDinner2 = cloneArray(mrsArrayMain);
            listArraysTuple.add(mrsArrayForDinner2);
            dinners2 = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Сонник"));
        }

        for (int i = 0; i < pfc.length; i++) {
            updateMRsArrayForMealTime(listArraysTuple.get(i), pfc, i);
        }

        Dish resultBreakfast = searchBestDishForMealTime(breakfasts, mrsArrayForBreakfast, checkLogicBetweenMRAndDish);

        var stop = 0;
    }


    /**
     * Поиск лучше блюда для приема пищи.
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

        // При ненахождении необходимого завтркака вообще.
        if (method.equals(checkLogicBetweenMRAndDishOnlyPPFC)) {
            // todo зарандомить выбор.
            return dishList.get(1);
        }

        // Вызов этой же ф-ии ток для КБЖУ.
        return searchBestDishForMealTime(dishList, mrs, checkLogicBetweenMRAndDishOnlyPPFC);
    }

    /**
     * Обновление значений МР для определенного приема питания.*/
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
