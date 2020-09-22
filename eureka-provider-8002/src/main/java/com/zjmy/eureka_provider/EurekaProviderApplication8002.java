package com.zjmy.eureka_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication8002.class, args);
    }

}
