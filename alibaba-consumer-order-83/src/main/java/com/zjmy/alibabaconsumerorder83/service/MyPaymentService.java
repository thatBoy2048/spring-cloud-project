package com.zjmy.alibabaconsumerorder83.service;

import com.zjmy.commons.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZhongXiang
 * Date on 2020/12/9  13:41
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface MyPaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")
    public AjaxResult paymentSQL(@PathVariable(value = "id") Long id);
}

