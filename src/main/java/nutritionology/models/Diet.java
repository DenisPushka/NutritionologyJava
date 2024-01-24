package nutritionology.models;

import jakarta.persistence.*;
import nutritionology.models.maps.DietDish;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Рацион.
 */
@Entity
@Table(name = "diet")
public class Diet {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "diet_id", length = 36, nullable = false, updatable = false)
    private UUID dietId;

    /**
     * Рацион - блюдо.
     */
    @OneToMany(mappedBy = "diet")
    private Set<DietDish> dietDishes;


    // region get and set

    public UUID getDietId() {
        return dietId;
    }

    public void setDietId(UUID dietId) {
        this.dietId = dietId;
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
}
