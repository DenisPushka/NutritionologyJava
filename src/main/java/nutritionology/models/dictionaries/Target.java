package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import nutritionology.models.Parameter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Цель.
 */
@Entity
@Table(name = "target")
public class Target {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "target_id", length = 36, nullable = false, updatable = false)
    private UUID targetId;

    /**
     * Название цели.
     */
    @Column(name = "name")
    private String name;

    /**
     * Процент.
     */
    @Column(name = "percent")
    private double percent;

    /**
     * Параметр.
     */
    @OneToMany(mappedBy = "target")
    private Set<Parameter> parameters;

    // region get and set

    public UUID getTargetId() {
        return targetId;
    }

    public void setTargetId(UUID targetId) {
        this.targetId = targetId;
    }

    /**
     * Название цели.
     */
    public String getName() {
        return name;
    }

    /**
     * Название цели.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Процент.
     */
    public double getPercent() {
        return percent;
    }

    /**
     * Процент.
     */
    public void setPercent(double percent) {
        this.percent = percent;
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

    // endregion
}
