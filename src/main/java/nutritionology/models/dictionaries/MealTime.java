package nutritionology.models.dictionaries;

import jakarta.validation.constraints.NotEmpty;
import nutritionology.models.Dish;
import jakarta.persistence.*;
import nutritionology.models.maps.DietDish;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Прием пищи.
 */
@Entity
@Table(name = "meal_time")
public class MealTime {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "meal_time_id", length = 36, nullable = false, updatable = false)
    private UUID mealTimeId;

    /**
     * Название приема пищи, пример: завтрак...
     */
    @Column(name = "Name", nullable = false)
    @NotEmpty
    private String name;

    /**
     * Блюда.
     */
    @ManyToMany(mappedBy = "mealTimes")
    private Set<Dish> dishes;

    /**
     * Рацион - блюдо.
     */
    @OneToMany(mappedBy = "mealTime", fetch = FetchType.LAZY)
    private Set<DietDish> dietDishes;

    // region gets nad sets

    public UUID getMealTimeId() {
        return mealTimeId;
    }

    public void setMealTimeId(UUID mealTimeId) {
        this.mealTimeId = mealTimeId;
    }

    /**
     * Название приема пищи, пример: завтрак...
     */
    public String getName() {
        return name;
    }

    /**
     * Название приема пищи, пример: завтрак...
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Блюда.
     */
    public Set<Dish> getDishes() {
        return dishes;
    }

    /**
     * Блюда.
     */
    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    /**
     * Рацион - блюдо.
     */
    public Set<DietDish> getDietDishes() {
        return dietDishes;
    }

    /**
     * Рацион - блюдо.
     */
    public void setDietDishes(Set<DietDish> dietDishes) {
        this.dietDishes = dietDishes;
    }

    // endregion

    @Override
    protected MealTime clone() throws CloneNotSupportedException {
        return (MealTime) super.clone();
    }
}
