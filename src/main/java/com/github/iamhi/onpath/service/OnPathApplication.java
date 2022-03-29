package com.github.iamhi.onpath.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.github.iamhi.onpath"})
@EnableReactiveMongoRepositories("com.github.iamhi.onpath.data")
@ConfigurationPropertiesScan("com.github.iamhi.onpath.config")
public class OnPathApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnPathApplication.class, args);
    }

}
