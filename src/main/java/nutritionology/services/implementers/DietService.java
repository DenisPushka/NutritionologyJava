package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.DayOfWeekRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.DietRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.MealTimeRepositoryJPA;
import nutritionology.models.Diet;
import nutritionology.models.dictionaries.DayOfWeek;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.services.interfaces.DietServiceInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Date 11.02.2024
 */
@Service
public class DietService implements DietServiceInterface {

    private final MealTimeRepositoryJPA mealTimeRepositoryJPA;
    private final DayOfWeekRepositoryJPA dayOfWeekRepositoryJPA;
    private final DietRepositoryJPA dietRepositoryJPA;

    public DietService(MealTimeRepositoryJPA mealTimeRepositoryJPA, DayOfWeekRepositoryJPA dayOfWeekRepositoryJPA, DietRepositoryJPA dietRepositoryJPA) {
        this.mealTimeRepositoryJPA = mealTimeRepositoryJPA;
        this.dayOfWeekRepositoryJPA = dayOfWeekRepositoryJPA;
        this.dietRepositoryJPA = dietRepositoryJPA;
    }

    @Override
    public MealTime[] getMealTimes() {
        return mealTimeRepositoryJPA.findAll().toArray(new MealTime[0]);
    }

    @Override
    public DayOfWeek[] getAllDaysOdfWeek() {
        return dayOfWeekRepositoryJPA.findAll().toArray(new DayOfWeek[0]);
    }

    @Override
    public Diet getDietById(String uuid) {
        return dietRepositoryJPA.findById(UUID.fromString(uuid)).get();
    }
}
