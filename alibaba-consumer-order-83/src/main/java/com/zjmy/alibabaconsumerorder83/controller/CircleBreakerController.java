package com.zjmy.alibabaconsumerorder83.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zjmy.alibabaconsumerorder83.service.MyPaymentService;
import com.zjmy.commons.domain.Payment;
import com.zjmy.commons.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ZhongXiang
 * Date on 2020/12/9  11:35
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyPaymentService paymentService;


    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public AjaxResult fallback(@PathVariable Long id) {
       AjaxResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, AjaxResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.get("payment") == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    //fallback
    public AjaxResult handlerFallback(@PathVariable Long id, Throwable e)
    {
        Payment payment = new Payment(id, "null");
        return AjaxResult.success("兜底异常 handlerFallback,exception内容" + e.getMessage()).put("payment", payment);
    }

    //blockHandler
    public AjaxResult blockHandler(@PathVariable Long id, BlockException blockException)
    {
        Payment payment = new Payment(id, "null");
        return AjaxResult.success("blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage()).put("payment", payment);
    }


    @GetMapping(value = "/consumer/paymentSQL/{id}")
    @SentinelResource(value ="paymentSQL")
    public AjaxResult paymentSQL(@PathVariable(value = "id") Long id)
    {

        return paymentService.paymentSQL(id);
    }


}

