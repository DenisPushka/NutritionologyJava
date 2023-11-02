package nutritionology.models;

import jakarta.persistence.*;
import nutritionology.models.dictionaries.*;
import nutritionology.models.user.User;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Параметр.
 */
@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "parameter_id", length = 36, nullable = false, updatable = false)
    private UUID parameterId;

    /**
     * Пол.
     */
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    /**
     * Возраст.
     */
    @Column(name = "age")
    private float age;

    /**
     * Вес (кг).
     */
    @Column(name = "weight")
    private double weight;

    /**
     * Рост (см).
     */
    @Column(name = "height")
    private double height;

    /**
     * Любимые продукты.
     */
    @ManyToMany
    @JoinTable(
            name = "parameter_like_product_map",
            joinColumns = @JoinColumn(name = "parameter_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> likeProducts;

    /**
     * Проблемные продукты.
     */
    @ManyToMany
    @JoinTable(
            name = "parameter_problem_product_map",
            joinColumns = @JoinColumn(name = "parameter_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> problemProducts;

    /**
     * Количество приемов пищи в день.
     */
    @Column(name = "count_meal_time_In_day")
    private int countMealTimeInDay;

    /**
     * Активность.
     */
    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    /**
     * Цель.
     */
    @ManyToOne
    @JoinColumn(name = "target_id", nullable = false)
    private Target target;

    /**
     * Пользователи.
     */
    @ManyToMany(mappedBy = "parameters")
    private Set<User> users;

    // region get && set

    public UUID getParameterId() {
        return parameterId;
    }

    public void setParameterId(UUID parameterId) {
        this.parameterId = parameterId;
    }

    /**
     * Пол.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Пол.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Возраст.
     */
    public float getAge() {
        return age;
    }

    /**
     * Возраст.
     */
    public void setAge(float age) {
        this.age = age;
    }

    /**
     * Вес (кг).
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Вес (кг).
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Рост (см).
     */
    public double getHeight() {
        return height;
    }

    /**
     * Рост (см).
     */
    public void setHeight(double height) {
        // todo validation.
        this.height = height;
    }

    /**
     * Любимые продукты.
     */
    public Set<Product> getLikeProducts() {
        return likeProducts;
    }

    /**
     * Любимые продукты.
     */
    public void setLikeProducts(Set<Product> likeProducts) {
        this.likeProducts = likeProducts;
    }

    /**
     * Проблемные продукты.
     */
    public Set<Product> getProblemProducts() {
        return problemProducts;
    }

    /**
     * Проблемные продукты.
     */
    public void setProblemProducts(Set<Product> problemProducts) {
        this.problemProducts = problemProducts;
    }

    /**
     * Количество приемов пищи в день.
     */
    public int getCountMealTimeInDay() {
        return countMealTimeInDay;
    }

    /**
     * Количество приемов пищи в день.
     */
    public void setCountMealTimeInDay(int countMealTimeInDay) {
        this.countMealTimeInDay = countMealTimeInDay;
    }

    /**
     * Активность.
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Активность.
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Цель.
     */
    public Target getTarget() {
        return target;
    }

    /**
     * Цель.
     */
    public void setTarget(Target target) {
        this.target = target;
    }

    /**
     * Пользователи.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Пользователи.
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // endregion
}
