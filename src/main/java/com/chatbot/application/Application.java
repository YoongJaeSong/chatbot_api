package com.chatbot.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    private static final String APPLICATION_LOCATION = "spring.config.location=" +
            "classpath:application.yml," +
            "classpath:application/db_application.yml," +
            "classpath:application/aws.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .properties(APPLICATION_LOCATION)
                .run(args);
    }

}
