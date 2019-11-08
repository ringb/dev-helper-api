package app.helper.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RestController
public class HealthController {

    @Value("${environment}")
    private String environment;

    @RequestMapping("/")
    public String index() {
        System.out.println(new Date().toString() +": Health Up - " + environment);
        return "up-" + environment;
    }

}