package nutritionology.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
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
@Data
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
     * Рост (м).
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

    @Transient
    private String simpleActivity;

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
    @JsonIgnore
    private Set<User> users;

}
