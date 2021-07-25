package com.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringWebAppApplication {
    
    public static void main(String[] args) {
        log.info("Added Logging mechanism");
        SpringApplication.run(SpringWebAppApplication.class, args);
    }

}
