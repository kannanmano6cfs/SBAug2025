package com.learning.exproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExProductServiceApplication.class, args);
    }

}
