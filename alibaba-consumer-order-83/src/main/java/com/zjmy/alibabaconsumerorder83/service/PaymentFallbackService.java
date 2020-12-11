package com.zjmy.alibabaconsumerorder83.service;

        import com.zjmy.commons.domain.Payment;
        import com.zjmy.commons.result.AjaxResult;
        import org.springframework.stereotype.Component;

/**
 * @author ZhongXiang
 * Date on 2020/12/9  13:45
 */
@Component
public class PaymentFallbackService implements MyPaymentService {

    @Override
    public AjaxResult paymentSQL(Long id) {
        return AjaxResult.success("服务降级返回").put("payment", new Payment(id,"yyyyyyyy"));
    }
}
