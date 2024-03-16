package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.ParameterRepositoryJPA;
import nutritionology.models.Parameter;
import org.springframework.stereotype.Service;

/**
 * @Date 08.03.2024
 */
@Service
public class ParameterService {
    private final ParameterRepositoryJPA parameterRepositoryJPA;

    public ParameterService(ParameterRepositoryJPA parameterRepositoryJPA) {
        this.parameterRepositoryJPA = parameterRepositoryJPA;
    }

    /**
     * Сохранение параметра.
     */
    public Parameter addParameter(Parameter parameter) {
        return parameterRepositoryJPA.save(parameter);
    }
}
