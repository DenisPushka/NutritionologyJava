package nutritionology.models.maps;

import jakarta.persistence.*;
import nutritionology.models.*;
import nutritionology.models.dictionaries.DayOfWeek;
import nutritionology.models.dictionaries.MealTime;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Рацион - блюдо.
 */
@Entity
@Table(name = "diet_dish")
public class DietDish {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "diet_dish_id", length = 36, nullable = false, updatable = false)
    private UUID dietDishId;

    /**
     * Рацион.
     */
    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    /**
     * Блюдо.
     */
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    /**
     * День недели.
     */
    @ManyToOne
    @JoinColumn(name = "day_of_week_id", nullable = false)
    private DayOfWeek dayOfWeek;

    /**
     * Номер недели.
     */
    @Column(name = "number_week")
    private int numberWeek;

    /**
     * Прием пищи.
     */
    @ManyToOne
    @JoinColumn(name = "meal_time_id", nullable = false)
    private MealTime mealTime;

    // region gets && sets

    public UUID getDietDishId() {
        return dietDishId;
    }

    public void setDietDishId(UUID dietDishId) {
        this.dietDishId = dietDishId;
    }

    /**
     * Рацион.
     */
    public Diet getDiet() {
        return diet;
    }

    /**
     * Рацион.
     */
    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    /**
     * Блюдо.
     */
    public Dish getDish() {
        return dish;
    }

    /**
     * Блюдо.
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    /**
     * День недели.
     */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * День недели.
     */
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * Номер недели.
     */
    public int getNumberWeek() {
        return numberWeek;
    }

    /**
     * Номер недели.
     */
    public void setNumberWeek(int numberWeek) {
        this.numberWeek = numberWeek;
    }

    /**
     * Прием пищи.
     */
    public MealTime getMealTime() {
        return mealTime;
    }

    /**
     * Прием пищи.
     */
    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }

    // endregion
}
