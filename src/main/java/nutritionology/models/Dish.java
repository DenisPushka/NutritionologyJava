package nutritionology.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import nutritionology.models.dictionaries.MealTime;
import nutritionology.models.dictionaries.Photo;
import nutritionology.models.dictionaries.TypeLunch;
import nutritionology.models.maps.DietDish;
import nutritionology.models.maps.ProductDish;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Блюдо.
 */
@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "dish_id", length = 36, nullable = false, updatable = false)
    private UUID dishId;

    // TODO NEED?
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
//
//    /**
//     * Процент дневной нормы.
//     */
//    // TODO THINK!
//    @Transient
//    private double dayNorm;

    /**
     * Продукты.
     */
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER)
    private Set<ProductDish> productDishes;

    /**
     * Фото блюда.
     */
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER)
    private Set<Photo> Photos;

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

    //region gets and sets

    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }

    /**
     * Номер продукта.
     */
    public int getNumberProduct() {
        return numberProduct;
    }

    /**
     * Номер продукта.
     */
    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    /**
     * Название.
     */
    public String getName() {
        return name;
    }

    /**
     * Название.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Вес.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Вес.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
//
//    /**
//     * Процент дневной нормы.
//     */
//    public double getDayNorm() {
//        return dayNorm;
//    }
//
//    /**
//     * Процент дневной нормы.
//     */
//    public void setDayNorm(double dayNorm) {
//        this.dayNorm = dayNorm;
//    }

    /**
     * Это напиток.
     */
    public boolean isDrink() {
        return isDrink;
    }

    /**
     * Это напиток.
     */
    public void setDrink(boolean drink) {
        isDrink = drink;
    }

    /**
     * Рецепт.
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Рецепт.
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Прием пищи.
     */
    public Set<MealTime> getMealTimes() {
        return mealTimes;
    }

    /**
     * Прием пищи.
     */
    public void setMealTimes(Set<MealTime> mealTimes) {
        this.mealTimes = mealTimes;
    }

    /**
     * Продукты.
     */
    public Set<ProductDish> getProductDishes() {
        return productDishes;
    }

    /**
     * Продукты.
     */
    public void setProductDishes(Set<ProductDish> productDishes) {
        this.productDishes = productDishes;
    }

    /**
     * Фото блюда.
     */
    public Set<Photo> getPhotos() {
        return Photos;
    }

    /**
     * Фото блюда.
     */
    public void setPhotos(Set<Photo> photos) {
        Photos = photos;
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

    /**
     * Тип обеда.
     */
    public TypeLunch getTypeLunch() {
        return typeLunch;
    }

    /**
     * Тип обеда.
     */
    public void setTypeLunch(TypeLunch typeLunch) {
        this.typeLunch = typeLunch;
    }

    //endregion

    /**
     * Клонирование объекта.
     *
     * @return Склонированный объект.
     */
    @Override
    public Dish clone() throws CloneNotSupportedException {
        Dish newDish = (Dish) super.clone();
        // TODO доделать.

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
