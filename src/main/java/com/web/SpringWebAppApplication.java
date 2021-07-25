package com.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplicat

        @Slf4j
@SpringBootApplication
public class SpringWebAppApplication {

    log.info("Added logging mechanism")
    public static void main(String[] args) {
        SpringApplication.run(SpringWebAppApplication.class, args);
    }

}
