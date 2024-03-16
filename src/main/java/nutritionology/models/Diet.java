package nutritionology.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import nutritionology.models.maps.DietDish;
import nutritionology.models.user.User;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Рацион.
 */
@Entity
@Table(name = "diet")
@Data
public class Diet {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "diet_id", length = 36, nullable = false, updatable = false)
    private UUID dietId;

    /**
     * Рацион - блюдо.
     */
    @OneToMany(mappedBy = "diet", fetch = FetchType.LAZY)
    private Set<DietDish> dietDishes;

    /**
     * Рацион - пользователь.
     */
    @ManyToMany(mappedBy = "diets")
    @JsonIgnore
    private Set<User> users;
}
