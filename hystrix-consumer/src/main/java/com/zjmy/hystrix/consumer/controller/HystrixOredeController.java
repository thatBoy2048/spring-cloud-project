package com.zjmy.hystrix.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //全局的
public class HystrixOredeController {

    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id) {
        String paymentOk = hystrixOrderService.hystrixOk(id);
        return paymentOk;
    }

//    精确配置方法
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
//    })
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand
    public String hystrixTimeout(@PathVariable("id") Integer id) {
        String paymentTimeout = hystrixOrderService.hystrixTimeout(id);
        return paymentTimeout;
    }


    /**
     * 兜底方法1
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {

        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }


    /**
     * 下面是全局fallback方法2
     */
    public String payment_Global_FallbackMethod(){

        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }


}

