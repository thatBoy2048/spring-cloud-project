package com.zjmy.consul_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZhongXiang
 * Date on 2020/9/25  15:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerApplication8007 {

    public static void main(String[] args) {
            SpringApplication.run(ConsulConsumerApplication8007.class, args);
        }

}
