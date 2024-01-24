package nutritionology.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Рецепт.
 */
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "recipe_id", length = 36, nullable = false, updatable = false)
    private UUID recipeId;

    /**
     * Описание.
     */
    @Column(name = "description")
    @NotEmpty
    private String description;

    /**
     * Блюдо.
     */
    @OneToOne(mappedBy = "recipe")
    private Dish dish;

    /**
     * Секретный.
     */
    @Column(name = "is_private")
    private boolean isPrivate;

    //region gets and sets

    public UUID getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(UUID recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * Описание.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Описание.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Секретный.
     */
    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Секретный.
     */
    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
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

    //endregion

    /**
     * Клонирование.
     *
     * @return Склонированный объект.
     */
    @Override
    protected Recipe clone() throws CloneNotSupportedException {
        return (Recipe) super.clone();
    }
}
