package app.helper.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HealthController {

    @RequestMapping("/")
    public String index() {
        System.out.println("health up!!!");
        return "up";
    }

}