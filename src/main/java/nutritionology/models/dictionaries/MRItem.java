package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import nutritionology.models.maps.ProductMRItem;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Элемент методических рекомендаций.
 */
@Entity
@Table(name = "mr_item")
@Data
public class MRItem {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "mr_item_id", length = 36, nullable = false, updatable = false)
    private UUID mrItemId;

    /**
     * СИ.
     */
    @ManyToOne
    @JoinColumn(name = "ms_id", nullable = false)
    private MS ms;

    /**
     * Название элемента.
     */
    @Column(name = "name")
    private String name;

    /**
     * Биологический элемент.
     */
    @ManyToOne
    @JoinColumn(name = "biological_element_id", nullable = false)
    private BiologicalElement biologicalElement;

    /**
     * Свойства продукта.
     */
    @OneToMany(mappedBy = "mrItem")
    @JsonIgnore
    private Set<ProductMRItem> productMRItems;

    /**
     * Методическая рекомендация.
     */
    @OneToMany(mappedBy = "mrItem")
    private Set<MR> mrs;
}
