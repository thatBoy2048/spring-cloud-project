package com.zjmy.alibabaconsumerorder83.controller;

import com.google.common.base.Equivalence;
import com.zjmy.commons.domain.AttaOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ZhongXiang
 * Date on 2020/11/3  14:28
 */
@RestController
@Slf4j
@RefreshScope
public class NacosOrderController
{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.config}")
    private String config;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        log.info("###############################" +config);
        return restTemplate.getForObject(serverUrl + "/payment/nacos/"+id,String.class);
    }

    @GetMapping("/consumer/payment/nacos/mongo")
    public AttaOrder createPayment()
    {
        log.info("###############################" +config);

        return restTemplate.getForObject(serverUrl + "/payment/nacos/mongo",AttaOrder.class);
    }


    @GetMapping("/consumer/payment/nacos/mongo/update")
    public AttaOrder updateMongoPayment()
    {
        log.info("###############################" +config);

        return restTemplate.getForObject(serverUrl + "/payment/nacos/mongo/update",AttaOrder.class);
    }


    @DeleteMapping("/consumer/payment/nacos/mongo/delete/{id}")
    public String deleteMongoPayment(@PathVariable("id") Integer id)
    {
        log.info("###############################" +config);

        restTemplate.delete(serverUrl + "/payment/nacos/mongo/delete/"+id);
         return "成功: "+ serverPort;
    }

    @GetMapping("/consumer/get/payment/nacos/mongo")
    public List<AttaOrder> deleteMongoPayment()
    {
        log.info("###############################" +config);
        String url = serverUrl + "/get/payment/nacos/mongo";
        List<AttaOrder> body = restTemplate.getForObject(url,List.class);
        return body;
    }

}
