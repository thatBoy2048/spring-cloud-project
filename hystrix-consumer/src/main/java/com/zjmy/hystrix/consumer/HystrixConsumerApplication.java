package com.zjmy.hystrix.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZhongXiang
 * Date on 2020/9/30  15:26
 */
@SpringBootApplication
@EnableFeignClients
public class HystrixConsumerApplication {

    public static void main(String[] args) {
            SpringApplication.run(HystrixConsumerApplication.class, args);
        }

}
