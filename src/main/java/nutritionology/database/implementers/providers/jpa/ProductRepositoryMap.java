package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.dictionaries.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepositoryMap extends JpaRepository<Product, UUID> {
}
