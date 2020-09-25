package com.zjmy.consul_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZhongXiang
 * Date on 2020/9/25  15:29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProviderApplication8006 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderApplication8006.class, args);
    }
}
