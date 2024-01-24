package nutritionology.services.interfaces;

import nutritionology.models.Parameter;
import nutritionology.models.dictionaries.Subscription;
import nutritionology.models.user.User;
import org.springframework.stereotype.Service;

/**
 * Интерфейс для запросов к таблице "Пользователь".
 * Включает запросы для таблиц: Параметр (Parameter), Подписка (Subscription).
 */
@Service
public interface UserServiceInterface {

    /**
     * Добавление парарметра.
     *
     * @param user      Пользователь которому добавляется параметр.
     * @param parameter Добавляемыый параметр.
     * @return Добавленный параметр.
     */
    Parameter addParameter(User user, Parameter parameter);

//    User Login(UserAuth user);

    /**
     * Регистрация пользовтеля.
     *
     * @param user Регистрируемый пользоваетль.
     * @return Зарегистрированный пользователь.
     */
    User registration(User user);

    /**
     * Добавление подписки пользовтелю.
     *
     * @param user Пользовтель, которому добавляется/изменяется подписка.
     * @return true - в случае успеха.
     */
    boolean addSubscription(User user, Subscription subscription);

    /**
     * Добавление подписки.
     *
     * @param subscription Добавляемая подписка.
     * @return Массив подписок.
     */
    Subscription[] addSubscription(Subscription subscription);

    /**
     * Получение всех подписок.
     *
     * @return Массив подписок.
     */
    Subscription[] getSubscriptions();
}
