package nutritionology.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.dictionaries.Photo;
import nutritionology.models.dictionaries.TypeLunch;
import nutritionology.models.maps.DietDish;
import nutritionology.models.maps.ProductDish;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * Блюдо.
 */
@Entity
@Table(name = "dish")
@Data
public class Dish {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "dish_id", length = 36, nullable = false, updatable = false)
    private UUID dishId;

    /**
     * Номер продукта.
     */
    @Column(name = "number_product")
    private int numberProduct;

    /**
     * Название.
     */
    @Column(name = "name")
    @NotEmpty
    private String name;

    /**
     * Вес.
     */
    @Column(name = "weight")
    private double weight;

    /**
     * Продукты.
     */
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER)
    private Set<ProductDish> productDishes;

    /**
     * Фото блюда.
     */
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER)
    private Set<Photo> photos;

    /**
     * Рецепт.
     */
    @Nullable
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
    private Recipe recipe;

    /**
     * Прием пищи.
     */
    @ManyToMany
    @JoinTable(
            name = "dish_meal_time_map",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_time_id"))
    private Set<MealTime> mealTimes;

    /**
     * Это напиток.
     */
    @Column(name = "is_drink")
    private boolean isDrink;

    /**
     * Рацион - блюдо.
     */
    @OneToMany(mappedBy = "dish")
    @JsonIgnore
    private Set<DietDish> dietDishes;

    /**
     * Тип обеда.
     */
    @ManyToOne
    @JoinColumn(name = "type_lunch_id")
    @Nullable
    private TypeLunch typeLunch;

    /**
     * Сумма по нутриентам.
     */
    @Transient
    private HashMap<String, Double> nutrients;

    /**
     * Клонирование объекта.
     *
     * @return Склонированный объект.
     */
    @Override
    public Dish clone() throws CloneNotSupportedException {
        Dish newDish = (Dish) super.clone();

//            dishId = this.dishId
//                    Name = (string)Name.Clone(),
//                    IsDrink = IsDrink,
//                    MealTime = new MealTime[MealTime.Length],
//                    Photos = new byte[Photos.Length][],
//                    Products = new ProductDishMap[Products.Length],
//                    Weight = Weight,
//                    Recipe = Recipe.Clone()


//        MealTime.CopyTo(newDish.MealTime, 0);
//        Products.CopyTo(newDish.Products, 0);

        return newDish;
    }
}
