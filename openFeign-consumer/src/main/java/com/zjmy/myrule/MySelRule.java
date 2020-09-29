package com.zjmy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhongXiang
 * Date on 2020/9/28  15:55
 */
@Configuration
public class MySelRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//负载均衡-随即策略
    }
}
