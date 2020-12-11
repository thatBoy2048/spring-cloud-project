package com.zjmy.alibabaproviderpayment9002.controller;

import com.zjmy.commons.domain.Payment;
import com.zjmy.commons.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ZhongXiang
 * Date on 2020/11/2  17:58
 */
@RestController
@Slf4j
public class PaymentController {

@Value("${server.port}")
private String serverPort;

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
        }
