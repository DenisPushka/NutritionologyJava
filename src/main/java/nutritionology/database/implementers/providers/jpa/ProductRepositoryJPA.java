package nutritionology.database.implementers.providers.jpa;

import jakarta.persistence.Tuple;
import nutritionology.database.models.Tuple2;
import nutritionology.models.dictionaries.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, UUID> {

    Product findFirstByProductFullName(String name);
}
