package com.zjmy.alibabaproviderpayment9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPayment9001Application.class, args);
    }

}
