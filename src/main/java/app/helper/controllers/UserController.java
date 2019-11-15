package app.helper.controllers;

import app.helper.constants.Status;
import app.helper.controllers.model.Response;
import app.helper.controllers.model.ResponseUser;
import app.helper.model.User;
import app.helper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<ResponseUser> users() {
        List<User> users = userService.findActive();
        List userResponse = new ArrayList();
        for (User user : users) {
            ResponseUser responseUser = new ResponseUser();
            responseUser.setEmail(user.getEmail());
            responseUser.setLastName(user.getLastName());
            userResponse.add(responseUser);
        }
        return userResponse;
    }

    @PostMapping(value = "/createUser", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response createUser() {
        User user = new User();
        user.setEmail("me@me.nl");
        userService.saveUser(user);
        return new Response(Status.SUCCESS);
    }

    @GetMapping("/createUserGet")
    public Response createUserGet() {
        User user = new User();
        user.setEmail("me@me.nl");
        user.setPassword("1234");
        user.setName("Hank");
        user.setLastName("Moody");
        userService.saveUser(user);
        return new Response(Status.SUCCESS);
    }

}