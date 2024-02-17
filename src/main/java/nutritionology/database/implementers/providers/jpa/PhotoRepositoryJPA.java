package nutritionology.database.implementers.providers.jpa;

import nutritionology.models.Dish;
import nutritionology.models.dictionaries.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @Date 11.02.2024
 */
@Repository
public interface PhotoRepositoryJPA extends JpaRepository<Photo, UUID> {

    List<Photo> findAllByDish(Dish dish);

}
