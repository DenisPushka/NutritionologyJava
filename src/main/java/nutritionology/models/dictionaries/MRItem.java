package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import nutritionology.models.maps.ProductMRItem;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Элемент методических рекомендаций.
 */
@Entity
@Table(name = "mr_item")
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
    private Set<ProductMRItem> productMRItems;

    /**
     * Методическая рекомендация.
     */
    @OneToMany(mappedBy = "mrItem")
    private Set<MR> mrs;

    // region gets and sets

    public UUID getMrItemId() {
        return mrItemId;
    }

    public void setMrItemId(UUID mrItemId) {
        this.mrItemId = mrItemId;
    }

    /**
     * СИ.
     */
    public MS getMs() {
        return ms;
    }

    /**
     * СИ.
     */
    public void setMs(MS ms) {
        this.ms = ms;
    }

    /**
     * Название элемента.
     */
    public String getName() {
        return name;
    }

    /**
     * Название элемента.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Биологический элемент.
     */
    public BiologicalElement getBiologicalElement() {
        return biologicalElement;
    }

    /**
     * Биологический элемент.
     */
    public void setBiologicalElement(BiologicalElement biologicalElement) {
        this.biologicalElement = biologicalElement;
    }

    /**
     * Свойства продукта.
     */
    public Set<ProductMRItem> getProductMRItems() {
        return productMRItems;
    }

    /**
     * Свойства продукта.
     */
    public void setProductMRItems(Set<ProductMRItem> productMRItems) {
        this.productMRItems = productMRItems;
    }

    /**
     * Методическая рекомендация.
     */
    public Set<MR> getMrs() {
        return mrs;
    }

    /**
     * Методическая рекомендация.
     */
    public void setMrs(Set<MR> mrs) {
        this.mrs = mrs;
    }

    // endregion


}
