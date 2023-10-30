package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Методические рекомендации (МР).
 * Methodological Recommendations (MR).
 */
@Entity
@Table(name = "mr")
public class MR {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "mr_id", length = 36, nullable = false, updatable = false)
    private UUID mrId;

    /**
     * Элемент МР.
     */
    @ManyToOne
    @JoinColumn(name = "mr_item_id", nullable = false)
    private MRItem mrItem;

    /**
     * Пол.
     */
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    /**
     * Данные.
     */
    @Column(name = "data")
    private double data;

    /**
     * Начальный возраст.
     */
    @Column(name = "start_age")
    private double startAge;

    /**
     * Конечный возраст параметра.
     */
    @Column(name = "finish_age")
    private double finishAge;

    // region get and sets

    public UUID getMrId() {
        return mrId;
    }

    public void setMrId(UUID mrId) {
        this.mrId = mrId;
    }

    /**
     * Биологический элемент.
     */
    public MRItem getMrItem() {
        return mrItem;
    }

    /**
     * Биологический элемент.
     */
    public void setMrItem(MRItem mrItem) {
        this.mrItem = mrItem;
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
     * Данные.
     */
    public double getData() {
        return data;
    }

    /**
     * Данные.
     */
    public void setData(double data) {
        this.data = data;
    }

    /**
     * Начальный возраст.
     */
    public double getStartAge() {
        return startAge;
    }

    /**
     * Начальный возраст.
     */
    public void setStartAge(double startAge) {
        this.startAge = startAge;
    }

    /**
     * Конечный возраст параметра.
     */
    public double getFinishAge() {
        return finishAge;
    }

    /**
     * Конечный возраст параметра.
     */
    public void setFinishAge(double finishAge) {
        this.finishAge = finishAge;
    }

    // endregion
}
