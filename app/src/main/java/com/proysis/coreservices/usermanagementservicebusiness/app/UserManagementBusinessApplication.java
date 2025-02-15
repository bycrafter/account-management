package com.proysis.coreservices.usermanagementservicebusiness.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.proysis.coreservices")
@EntityScan("com.proysis.coreservices")
@EnableJpaRepositories("com.proysis.coreservices")
public class UserManagementBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementBusinessApplication.class, args);
    }

}
