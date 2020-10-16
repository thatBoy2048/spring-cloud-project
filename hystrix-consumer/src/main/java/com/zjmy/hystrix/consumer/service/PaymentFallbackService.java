package com.zjmy.hystrix.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author ZhongXiang
 * Date on 2020/10/12  16:40
 *
 * 服务降级 最终实现方法 解决高耦合问题
 */
@Component
public class PaymentFallbackService implements HystrixOrderService {

    @Override
    public String hystrixOk(Integer id) {
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬) PaymentFallbackService  hystrixOk"+id  ;
    }

    @Override
    public String hystrixTimeout(Integer id) {
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬) PaymentFallbackService  timeOut:"+id;
    }
}
