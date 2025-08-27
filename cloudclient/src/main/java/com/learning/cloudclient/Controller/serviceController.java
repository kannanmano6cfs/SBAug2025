package com.learning.cloudclient.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serviceController {

    @Autowired
    private Environment env;

    @GetMapping("/home")
    public String home() {
        return env.getProperty("welcome.message");
    }

}
