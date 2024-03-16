package nutritionology.services.implementers;

import nutritionology.database.implementers.providers.jpa.DietRepositoryJPA;
import nutritionology.database.implementers.providers.jpa.UserRepositoryJPA;
import nutritionology.models.Diet;
import nutritionology.models.Parameter;
import nutritionology.models.user.User;
import nutritionology.services.CreatorMenu;
import org.springframework.stereotype.Service;

/**
 * Сервис для пользователя.
 *
 * @Date 03.03.2024
 */
@Service
public class UserService {
    private final CreatorMenu creatorMenu;
    private final ParameterService parameterService;
    private final UserRepositoryJPA userRepositoryJPA;
    private final DietRepositoryJPA dietRepositoryJPA;

    public UserService(CreatorMenu creatorMenu, ParameterService parameterService, UserRepositoryJPA userRepositoryJPA, DietRepositoryJPA dietRepositoryJPA) {
        this.creatorMenu = creatorMenu;
        this.parameterService = parameterService;
        this.userRepositoryJPA = userRepositoryJPA;
        this.dietRepositoryJPA = dietRepositoryJPA;
    }

    public Diet createMenu(User user, Parameter parameter) {

        parameter = parameterService.addParameter(parameter);

        // 1. сохранение параметра пользователю. def user = 0DADD5BD-43A1-47A0-9405-ADC2C699E94A\
        // 2. сохранение пользователя (если не сохранен) и рациона.

        if (!user.getParameters().contains(parameter)) {
            user.getParameters().add(parameter);
            userRepositoryJPA.save(user);
        }

        Diet diet = creatorMenu.createMenuToOneDay(parameter);

        if (!user.getDiets().contains(diet)) {
            user.getDiets().add(diet);
            diet = dietRepositoryJPA.save(diet);
            userRepositoryJPA.save(user);
        }

        return diet;
    }

    public User auth(String login, String password) {
        if (userRepositoryJPA.findFirstByEmail(login, password) == null) {

        }

        return null;
    }
}
