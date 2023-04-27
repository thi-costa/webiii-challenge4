package com.example.gatewayspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewaySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySpringApplication.class, args);
    }

}
