package com.zjmy.eureka_provider.service;

/**
 * @author ZhongXiang
 * Date on 2020/9/30  14:02
 */
public interface HystrixPaymentService {
// 服务降级
    /**
     * 正常
     * @param id
     * @return
     */
    String hystrixPaymentOk(Integer id);

    /**
     * 超时
     * @param id
     * @return
     */
    String hystrixPaymentTimeout(Integer id);

//   服务熔断
    /**
     *
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
