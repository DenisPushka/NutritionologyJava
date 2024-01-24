import nutritionology.Application;
import nutritionology.database.implementers.providers.jpa.ActivityRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.DishRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MealTimeRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MrRepositoryJPA;
import nutritionology.models.Dish;
import nutritionology.models.Parameter;
import nutritionology.services.CreatorMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Date 08.01.2024
 */
@SpringBootTest(classes = Application.class)
public class TestForCreateMenu {

    @Test
    void exampleTest(@Autowired MrRepositoryJPA mrRepositoryJPA) {
        var objs = mrRepositoryJPA.GetDataFromPerson(21, "Ж");

        var stop = 0;
    }

    @Test
    void testPPFC(@Autowired ActivityRepositoryJPA activityRepositoryJPA) {
        var objs = activityRepositoryJPA.GetPPFCFromActivity(21, "2", "5675D50D-35F7-4708-81B3-2AA6152F799D");

        var stop = 0;
    }

    @Test
    void testGetAllBreakfasts(
            @Autowired MealTimeRepositoryJPA mealTimeRepositoryJPA,
            @Autowired DishRepositoryJPA dishRepositoryJPA) {
        List<Dish> breakfasts = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Завтрак"));
        List<Dish> launches = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Обед"));
        List<Dish> launches2 = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Полдник"));
        List<Dish> dinners = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Ужин"));
        List<Dish> dinners2 = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Сонник"));

        var stop = 0;
    }

    @Test
    void firstBigTest(@Autowired CreatorMenu creatorMenu) {
        Parameter parameter = new Parameter();
        parameter.setAge(21);
        parameter.setCountMealTimeInDay(3);

        creatorMenu.CreateMenuToOneDay(parameter);
    }

    @Test
    void testSearchBestBreakfast(
            @Autowired MealTimeRepositoryJPA mealTimeRepositoryJPA,
            @Autowired DishRepositoryJPA dishRepositoryJPA) {
        List<Dish> breakfasts = dishRepositoryJPA.findDishesByMealTimes(mealTimeRepositoryJPA.findFirstByName("Завтрак"));

    }
}
