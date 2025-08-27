package com.learning.eurekaclienta.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientAController {

    @GetMapping("/")
    public String clientA() {
        return "Welcome to the Client A Service";
    }
}
