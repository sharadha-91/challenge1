package com.app.challenge_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Challenge1Application {

    public static void main(String[] args) {
        SpringApplication.run(Challenge1Application.class, args);
    }

}
