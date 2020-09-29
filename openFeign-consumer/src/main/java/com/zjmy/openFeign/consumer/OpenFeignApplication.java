package com.zjmy.openFeign.consumer;

import com.zjmy.myrule.MySelRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZhongXiang
 * Date on 2020/9/29  14:45
 */
@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name = "EUREKA-PROVIDER-ATTA",configuration = MySelRule.class)
public class OpenFeignApplication {

    public static void main(String[] args) {
            SpringApplication.run(OpenFeignApplication.class, args);
        }

}
