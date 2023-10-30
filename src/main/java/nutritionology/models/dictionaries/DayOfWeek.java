package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import nutritionology.models.maps.DietDish;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * День недели.
 */
@Entity
@Table(name = "day_of_week")
public class DayOfWeek {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "day_of_week_id", length = 36, nullable = false, updatable = false)
    private UUID dayOfWeekId;

    /**
     * Короткое название.
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * Полное название.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * Рацион - блюдо.
     */
    @OneToMany(mappedBy = "dayOfWeek", fetch = FetchType.LAZY)
    private Set<DietDish> dietDishes;

    // region gets and sets

    public UUID getDayOfWeekId() {
        return dayOfWeekId;
    }

    public void setDayOfWeekId(UUID dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }

    /**
     * Короткое название.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Короткое название.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Полное название.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Полное название.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    /**
     * Клонирование.
     */
    @Override
    protected DayOfWeek clone() throws CloneNotSupportedException {
        // todo
        return (DayOfWeek) super.clone();
    }
}
