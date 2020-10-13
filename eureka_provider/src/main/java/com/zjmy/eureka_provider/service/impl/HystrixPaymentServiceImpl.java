package com.zjmy.eureka_provider.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjmy.eureka_provider.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhongXiang
 * Date on 2020/9/30  14:03
 */
@Service
@Transactional
@Slf4j
public class HystrixPaymentServiceImpl implements HystrixPaymentService {

    @Value("${server.port}")
    private String serverPort;


    @Override
    public String hystrixPaymentOk(Integer id) {
        String rest = "线程池："+Thread.currentThread().getName()+" hystrixPaymentOk,id："+id+" 端口："+serverPort+" ";
        log.info(rest);
        return rest;
    }

    /**
     * 设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法处理，作服务降级fallback
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeoutInfo_handler",commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    }) //3秒钟以内就是正常的业务逻辑
    public String hystrixPaymentTimeout(Integer id) {
        int timeNumber = 999;
        try { TimeUnit.MILLISECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        String rest ="线程池："+Thread.currentThread().getName()+" hystrixPaymentTimeout,id："+id+"  "+"哈哈哈哈哈哈"+" 耗时:"+timeNumber+"(秒)" + "端口："+ serverPort;
        log.info(rest);
        return rest;
    }


    public String paymentTimeoutInfo_handler(Integer id){
        String error = "线程池："+Thread.currentThread().getName() + "（*＾系统繁忙，请稍后再试！！！＾*） + paymentTimeoutInfo_handler:"+id+"";
        log.info(error);
        return error;
    }

}
