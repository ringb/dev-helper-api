package app.helper.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HealthController {

    @Value("${environment}")
    private String environment;

    @GetMapping("/")
    public String index() {
        System.out.println(new Date().toString() +": Health Up - " + environment);
        return "up-" + environment;
    }

}