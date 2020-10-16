package com.zjmy.eureka_provider.controller;

import com.zjmy.eureka_provider.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/9/30  13:58
 */
@RestController
@Slf4j
public class HystrixController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id){
        String paymentOk = hystrixPaymentService.hystrixPaymentOk(id);
        return paymentOk;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Integer id){
        String paymentTimeout= hystrixPaymentService.hystrixPaymentTimeout(id);
        return paymentTimeout;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = hystrixPaymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }






}
