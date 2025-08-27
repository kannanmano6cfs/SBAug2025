package com.learning.eurekaclientb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class clientBController {

    @GetMapping("/")
    public String clientB() {
        return "Welcome to the client B Service";
    }
}
