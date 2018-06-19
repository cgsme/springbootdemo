package com.tutu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cguisheng
 */
@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    String home() {
        return "hello spring boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
