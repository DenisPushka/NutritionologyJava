package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import nutritionology.models.Parameter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Цель.
 */
@Entity
@Table(name = "target")
@Data
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
    @NotEmpty
    private String name;

    /**
     * Процент.
     */
    @Column(name = "percent_target")
    private float percent;

    /**
     * Параметр.
     */
    @OneToMany(mappedBy = "target")
    @JsonIgnore
    private Set<Parameter> parameters;
}
