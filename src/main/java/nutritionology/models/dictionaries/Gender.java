package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import nutritionology.models.Parameter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Пол.
 */
@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "gender_id", length = 36, nullable = false, updatable = false)
    private UUID genderId;

    /**
     * Короткое название.
     */
    @Column(name = "short_name", nullable = false)
    @NotEmpty
    private String shortName;

    /**
     * Полное название.
     */
    @Column(name = "full_name", nullable = false)
    @NotEmpty
    private String fullName;

    /**
     * Параметр.
     */
    @OneToMany(mappedBy = "gender")
    private Set<Parameter> parameters;

    /**
     * Методические рекомендации.
     */
    @OneToMany(mappedBy = "gender")
    private Set<MR> mrs;

    /**
     * Активность.
     */
    @OneToMany(mappedBy = "gender")
    private Set<Activity> activities;

    // region gets and sets

    public UUID getGenderId() {
        return genderId;
    }

    public void setGenderId(UUID genderId) {
        this.genderId = genderId;
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
     * Параметр.
     */
    public Set<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Параметр.
     */
    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Методические рекомендации.
     */
    public Set<MR> getMrs() {
        return mrs;
    }

    /**
     * Методические рекомендации.
     */
    public void setMrs(Set<MR> mrs) {
        this.mrs = mrs;
    }

    /**
     * Активность.
     */
    public Set<Activity> getActivities() {
        return activities;
    }

    /**
     * Активность.
     */
    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    // endregion
}
