package com.zjmy.hystrixdashboard9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001Application.class, args);
    }




}
