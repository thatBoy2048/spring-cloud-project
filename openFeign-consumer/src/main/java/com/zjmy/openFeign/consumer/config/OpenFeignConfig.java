package com.zjmy.openFeign.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author ZhongXiang
 * Date on 2020/9/29  15:58
 * OpenFeign日志记录级别
 */
@Configuration
public class OpenFeignConfig {

     @Bean
     public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
