package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.maps.ProductMRItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Date 08.01.2024
 */
@Repository
public interface ProductMRItemJPA extends JpaRepository<ProductMRItem, UUID> {
}
