package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.ProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Date 08.01.2024
 */
@Repository
public interface ProductRepositoryNameJPA  extends JpaRepository<ProductName, UUID> {

    ProductName findFirstByName(String name);
}
