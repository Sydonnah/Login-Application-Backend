package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoginApplication {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy(){
        return args->{};
    }

    public static void main(String[] args) {

        SpringApplication.run(LoginApplication.class, args);
    }

}
