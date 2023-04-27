package com.example.pixserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PixServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixServiceRegistryApplication.class, args);
    }

}
