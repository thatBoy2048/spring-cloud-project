package com.zjmy.hystrix.consumer.controller;

import com.zjmy.hystrix.consumer.service.HystrixOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/9/30  15:22
 */
@RestController
public class HystrixOredeController {

    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id){
        String paymentOk = hystrixOrderService.hystrixOk(id);
        return paymentOk;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Integer id){
        String paymentTimeout= hystrixOrderService.hystrixTimeout(id);
        return paymentTimeout;
    }

}
