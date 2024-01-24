package nutritionology.controllers;

import nutritionology.models.BaseResponse;
import nutritionology.models.user.User;
import nutritionology.models.user.UserAuth;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/login")
//    public User showStatus1(@RequestBody UserAuth userAuth) {
    public User showStatus1(@RequestBody String userAuth) {
        return new User();
    }
}
