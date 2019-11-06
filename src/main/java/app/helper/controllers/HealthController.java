package app.helper.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RestController
public class HealthController {

    @RequestMapping("/")
    public String index() {
        System.out.println(new Date().toString() +": Health Up!!!!");
        return "up";
    }

}