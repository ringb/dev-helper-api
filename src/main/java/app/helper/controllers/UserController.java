package app.helper.controllers;

import app.helper.constants.Status;
import app.helper.controllers.model.Response;
import app.helper.model.User;
import app.helper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String users() {
        return "users!";
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