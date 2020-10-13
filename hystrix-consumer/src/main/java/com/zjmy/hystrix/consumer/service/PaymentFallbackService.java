package com.zjmy.hystrix.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author ZhongXiang
 * Date on 2020/10/12  16:40
 */
@Component
public class PaymentFallbackService implements HystrixOrderService {

    @Override
    public String hystrixOk(Integer id) {
        return "hystrixOk"+id;
    }

    @Override
    public String hystrixTimeout(Integer id) {
        return "timeOut:"+id;
    }
}
