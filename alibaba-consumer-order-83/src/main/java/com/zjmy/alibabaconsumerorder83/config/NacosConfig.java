package com.zjmy.alibabaconsumerorder83.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhongXiang
 * Date on 2020/11/3  14:27
 */
@Configuration
public class NacosConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {

        return new RestTemplate();
    }
}
