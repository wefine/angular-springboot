package com.wefine.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class AngularSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngularSpringbootApplication.class, args);
    }
}
