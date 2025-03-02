package com.bycrafter.core.accountmanagement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bycrafter.core")
@EntityScan("com.bycrafter.core")
@EnableJpaRepositories("com.bycrafter.core")
public class AccountManagementBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementBusinessApplication.class, args);
    }

}
