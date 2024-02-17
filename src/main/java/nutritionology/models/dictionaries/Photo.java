package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nutritionology.models.Dish;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Фото.
 */
@Builder
@Entity
@Table(name = "photo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "photo_id", length = 36, nullable = false, updatable = false)
    private UUID photo_id;

    /**
     * Значение.
     */
    @Column(name = "photo_name")
    private String photoName;

    /**
     * Блюдо.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", nullable = false)
    @JsonIgnore
    private Dish dish;

    @Transient
    private String data;
}
