package com.zjmy.hystrix.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZhongXiang
 * Date on 2020/9/30  15:06
 */
@Component
@FeignClient(value = "EUREKA-PROVIDER-ATTA")
public interface HystrixOrderService {
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id);

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Integer id);
}
