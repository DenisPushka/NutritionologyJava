package nutritionology.controllers;

import nutritionology.models.BaseResponse;
import nutritionology.models.Diet;
import nutritionology.models.Parameter;
import nutritionology.models.user.User;
import nutritionology.models.user.UserAuth;
import nutritionology.services.implementers.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/login")
//    public User showStatus1(@RequestBody UserAuth userAuth) {
    public HttpEntity showStatus1(@RequestBody String login, @RequestBody String password) {
        return new HttpEntity(userService.auth(login, password));
    }

    @PostMapping("/add-parameter")
    public HttpEntity<Diet> addParameterToUser(@RequestBody User user, @RequestBody Parameter parameter){
        return new HttpEntity<>(userService.createMenu(user, parameter), new HttpHeaders());
    }
}
