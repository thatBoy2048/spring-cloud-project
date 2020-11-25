package com.zjmy.alibabaproviderpayment9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableDiscoveryClient
//@EnableTransactionManagement
//@ComponentScan("com.zjmy.*")
public class AlibabaProviderPayment9001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPayment9001Application.class, args);
    }

}
