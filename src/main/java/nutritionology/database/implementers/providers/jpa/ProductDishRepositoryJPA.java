package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.maps.ProductDish;
import nutritionology.models.maps.ProductDishKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date 14.01.2024
 */
public interface ProductDishRepositoryJPA extends JpaRepository<ProductDish, ProductDishKey> {

}
