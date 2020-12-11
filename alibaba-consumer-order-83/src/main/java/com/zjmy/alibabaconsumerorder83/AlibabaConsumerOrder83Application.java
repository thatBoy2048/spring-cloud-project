package com.zjmy.alibabaconsumerorder83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaConsumerOrder83Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(AlibabaConsumerOrder83Application.class, args);
    }

}
