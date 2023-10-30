package nutritionology.models.user;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Компания.
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "company_id", length = 36, nullable = false, updatable = false)
    private UUID companyId;

    /**
     * Название компании.
     */
    @Column(name = "name")
    private String name;

    /**
     * Пользователь.
     */
    @OneToOne(mappedBy = "company")
    private User user;

    // region get and set

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    /**
     * Название компании.
     */
    public String getName() {
        return name;
    }

    /**
     * Название компании.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Пользователь.
     */
    public User getUser() {
        return user;
    }

    /**
     * Пользователь.
     */
    public void setUser(User user) {
        this.user = user;
    }

    // endregion
}
