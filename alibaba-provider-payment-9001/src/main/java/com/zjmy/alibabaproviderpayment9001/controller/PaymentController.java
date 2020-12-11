package com.zjmy.alibabaproviderpayment9001.controller;

import com.zjmy.alibabaproviderpayment9001.service.PaymentService;
import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.commons.domain.Payment;
import com.zjmy.commons.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author ZhongXiang
 * Date on 2020/11/2  17:58
 */
@RestController
@Slf4j
@RefreshScope
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.config}")
    private String config;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "Hello Nacos Discovery: " + serverPort + "\tid: " + id;

    }
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static{
        hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public AjaxResult paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        return AjaxResult.success("成功:"+serverPort).put("payment",payment);
    }




    @GetMapping("/payment/nacos/mongo")
    public AttaOrder createPaymentMongo(){
        List<AttaOrder> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            AttaOrder order = new AttaOrder();
            order.setName("mongo订单2");
            order.setOrderCode("xmtp00001");
            order.setId(789+i);
            order.setPort("9011");
            order.setAmount(89.023);
            order.setCreateBy("123123");
            order.setCreateTime(new Date());
            order.setOrderNum(808080);
            list.add(order);
        }
        return paymentService.createPaymentMongo(list);

    }

    @GetMapping("/payment/nacos/mongo/update")
    public AttaOrder updatePaymentMongo(){
        AttaOrder order = new AttaOrder();
        order.setName("奥迪A5全款");
        order.setOrderCode("zfb00002");
        order.setId(12313212);
        order.setCreateBy("78909");
//        order.setPort("9011");
//        order.setAmount(89.023);
//        order.setCreateTime(new Date());
//        order.setOrderNum(808080);
        return paymentService.updatePaymentMongo(order);
    }

    @DeleteMapping("/payment/nacos/mongo/delete/{id}")
    public String deletePaymentMongo(@PathVariable("id") Integer id){
        log.info("#################################"+ config);
        return paymentService.deletePaymentMongo(id);
    }

    @GetMapping("/get/payment/nacos/mongo")
    public List<AttaOrder> selectPaymentMongo(){
        AttaOrder order = new AttaOrder();
        order.setName("A5");
        return paymentService.selectPaymentMongo(order);
    }
}
