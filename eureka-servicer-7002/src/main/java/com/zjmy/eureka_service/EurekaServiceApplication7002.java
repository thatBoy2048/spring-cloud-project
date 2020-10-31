package com.zjmy.eureka_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZhongXiang
 * Date on 2020/9/22  16:30
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication7002.class, args);
    }

}
