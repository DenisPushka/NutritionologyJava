package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriptionRepositoryJPA extends JpaRepository<Subscription, UUID> {
}
