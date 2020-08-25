package com.zjmy.eureka_consumer.controller;

import com.zjmy.eureka_consumer.service.AttaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  13:36
 */
@RestController
@RequestMapping("/project/atta")
public class AttaConsumerController {

    @Autowired
    private AttaConsumerService attaConsumerService;

    @GetMapping("/eureka/{id}")
    public Object selectAttaById(@PathVariable Integer id){
        return  attaConsumerService.selectAttaById(id);
    }
}
