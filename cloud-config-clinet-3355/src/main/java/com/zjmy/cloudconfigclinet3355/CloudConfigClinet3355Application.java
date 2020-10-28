package com.zjmy.cloudconfigclinet3355;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClinet3355Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClinet3355Application.class, args);
    }

}
