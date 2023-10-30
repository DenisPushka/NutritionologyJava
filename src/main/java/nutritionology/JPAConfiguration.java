package nutritionology;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "nutritionology.database.implementers.providers.jpa")
public class JPAConfiguration {
}
