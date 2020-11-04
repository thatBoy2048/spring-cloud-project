package com.zjmy.alibabaconsumerorder83.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhongXiang
 * Date on 2020/11/3  14:28
 */
@RestController
@Slf4j
public class NacosOrderController
{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {

        return restTemplate.getForObject(serverUrl + "/payment/nacos/"+id,String.class);
    }


}
