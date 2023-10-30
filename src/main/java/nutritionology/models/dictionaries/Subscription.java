package nutritionology.models.dictionaries;

import jakarta.persistence.*;
import nutritionology.models.user.User;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

/**
 * Подписка.
 */
@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "subscription_id", length = 36, nullable = false, updatable = false)
    private UUID subscriptionId;

    /**
     * Название.
     */
    @Column(name = "name")
    private String name;

    /**
     * Цена.
     */
    @Column(name = "price")
    private int price;

    /**
     * Пользователи.
     */
    @OneToMany(mappedBy = "subscription")
    private Set<User> users;

    // region get and set

    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(UUID subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Название.
     */
    public String getName() {
        return name;
    }

    /**
     * Название.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Цена.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Цена.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Пользователи.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Пользователи.
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // endregion
}
