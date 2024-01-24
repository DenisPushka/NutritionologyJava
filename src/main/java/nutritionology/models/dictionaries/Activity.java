package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import nutritionology.models.Parameter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Физическая активность.
 */
@Entity
@Table(name = "activity")
@Data
public class Activity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "activity_id", length = 36, nullable = false, updatable = false)
    private UUID activityId;

    /**
     * Имя у физ активности.
     */
    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    /**
     * Калории.
     */
    @Column(name = "power", nullable = false)
    private double power;

    /**
     * Количество белков на 1 кг.
     */
    @Column(name = "protein_count", nullable = false)
    private double proteinCount;

    /**
     * Количество жиров на 1 кг.
     */
    @Column(name = "fat_count", nullable = false)
    private double fatCount;

    /**
     * Количество углеводов на 1 кг.
     */
    @Column(name = "carbohydrate_count", nullable = false)
    private double carbohydrateCount;

    /**
     * Параметр.
     */
    @OneToMany(mappedBy = "activity")
    private Set<Parameter> parameters;

    /**
     * Пол.
     */
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    /**
     * Начальный возраст.
     * */
    @Column(name = "start_age", nullable = false)
    private int startAge;

    /**
     * Конечный возраст.
     * */
    @Column(name = "finish_age", nullable = false)
    private int finishAge;

//    // region gets and sets
//
//    public UUID getActivityId() {
//        return activityId;
//    }
//
//    public void setActivityId(UUID activityId) {
//        this.activityId = activityId;
//    }
//
//    /**
//     * Имя у физ активности.
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * Имя у физ активности.
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * Количество белков на 1 кг.
//     */
//    public double getProteinCount() {
//        return proteinCount;
//    }
//
//    /**
//     * Количество белков на 1 кг.
//     */
//    public void setProteinCount(double proteinCount) {
//        this.proteinCount = proteinCount;
//    }
//
//    /**
//     * Количество жиров на 1 кг.
//     */
//    public double getFatCount() {
//        return fatCount;
//    }
//
//    /**
//     * Количество жиров на 1 кг.
//     */
//    public void setFatCount(double fatCount) {
//        this.fatCount = fatCount;
//    }
//
//    /**
//     * Количество углеводов на 1 кг.
//     */
//    public double getCarbohydrateCount() {
//        return carbohydrateCount;
//    }
//
//    /**
//     * Количество углеводов на 1 кг.
//     */
//    public void setCarbohydrateCount(double carbohydrateCount) {
//        this.carbohydrateCount = carbohydrateCount;
//    }
//
//    /**
//     * Параметр.
//     */
//    public Set<Parameter> getParameters() {
//        return parameters;
//    }
//
//    /**
//     * Параметр.
//     */
//    public void setParameters(Set<Parameter> parameters) {
//        this.parameters = parameters;
//    }
//
//    /**
//     * Пол.
//     */
//    public Gender getGender() {
//        return gender;
//    }
//
//    /**
//     * Пол.
//     */
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    // endregion
}
