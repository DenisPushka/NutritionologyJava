package nutritionology.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Set;
import java.util.UUID;

/**
 * Биологический элемент.
 */
@Entity
@Table(name = "biological_element")
public class BiologicalElement {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "biological_element_id", length = 36, nullable = false, updatable = false)
    private UUID biologicalElementId;

    /**
     * Короткое название.
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * Полное название.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * МР элементы.
     */
    @OneToMany(mappedBy = "biologicalElement")
    @JsonIgnore
    private Set<MRItem> mrItems;

    // region gets and sets

    public UUID getBiologicalElementId() {
        return biologicalElementId;
    }

    public void setBiologicalElementId(UUID biologicalElementId) {
        this.biologicalElementId = biologicalElementId;
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
     * МР элементы.
     */
    public Set<MRItem> getMrItems() {
        return mrItems;
    }

    /**
     * МР элементы.
     */
    public void setMrItems(Set<MRItem> mrItems) {
        this.mrItems = mrItems;
    }

    // endregion

    /**
     * Клонирование.
     *
     * @return Склонированный объект.
     */
    @Override
    protected BiologicalElement clone() throws CloneNotSupportedException {
        // todo клонирование родителя.
        return (BiologicalElement) super.clone();
    }
}
