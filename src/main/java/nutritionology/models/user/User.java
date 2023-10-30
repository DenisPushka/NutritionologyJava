package nutritionology.models.user;

import jakarta.persistence.*;
import nutritionology.models.Parameter;
import nutritionology.models.dictionaries.Subscription;
import nutritionology.models.dictionaries.UserRole;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Общий пользователь.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "user_id", length = 36, nullable = false, updatable = false)
    private UUID userId;

    /**
     * Фото.
     */
    @Column(name = "photo")
    private String photo;

    /**
     * Подписка.
     */
    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    /**
     * Параметры для пользователя.
     */
    @ManyToMany
    @JoinTable(
            name = "parameter_map",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    private Set<Parameter> parameters;

    /**
     * Физ лицо.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    /**
     * Компания.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    /**
     * Роль пользователя.
     */
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    // region get and set

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Фото.
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Фото.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Подписка.
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Подписка.
     */
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Параметры для пользователя.
     */
    public Set<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Параметры для пользователя.
     */
    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Физ лицо.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Физ лицо.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Компания.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Компания.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Роль пользователя.
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * Роль пользователя.
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    // endregion
}
