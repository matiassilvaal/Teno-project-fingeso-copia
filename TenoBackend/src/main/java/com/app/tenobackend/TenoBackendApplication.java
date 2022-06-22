package com.app.tenobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.sql2o.Sql2o;

@SpringBootApplication
@EnableMongoRepositories
public class TenoBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(TenoBackendApplication.class, args);
    }

}
