package com.learning.eurekaclientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaclientBApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaclientBApplication.class, args);
    }

}
