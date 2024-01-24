package nutritionology.models.user;

import org.springframework.stereotype.Component;

/**
 * User for login.
 * @Date 03.11.2023
 */
@Component
public class UserAuth {

    private String login;

    private String password;

    // region gets and sets

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // endregion
}
