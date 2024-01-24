package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import nutritionology.models.Dish;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Тип обеда.
 */
@Entity
@Table(name = "type_lunch")
public class TypeLunch {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "type_lunch_id", length = 36, nullable = false, updatable = false)
    private UUID typeLunchId;

    /**
     * Название типа.
     */
    @Column(name = "name")
    private String name;

    /**
     * Блюда.
     */
    @OneToMany(mappedBy = "typeLunch")
    private Set<Dish> dishes;

    // region get and set

    public UUID getTypeLunchId() {
        return typeLunchId;
    }

    public void setTypeLunchId(UUID typeLunchId) {
        this.typeLunchId = typeLunchId;
    }

    /**
     * Название типа.
     */
    public String getName() {
        return name;
    }

    /**
     * Название типа.
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

    // endregion
}
