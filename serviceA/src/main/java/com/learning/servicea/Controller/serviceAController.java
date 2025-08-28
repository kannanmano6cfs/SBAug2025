package com.learning.servicea.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicea")
public class serviceAController {

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String serviceA() {
        return "Welcome to the service running on port "+env.getProperty("server.port");
    }
}
