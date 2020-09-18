package com.zjmy.eureka_consumer.controller;

import com.zjmy.commons.constants.EurekaConsumreConstants;
import com.zjmy.commons.domain.AttaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  13:36
 */
@RestController
@RequestMapping("/project/atta")
public class AttaConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/eureka/{id}")
    public AttaOrder selectAttaById(@PathVariable Integer id){
        return restTemplate.getForObject(EurekaConsumreConstants.ATTA_URI+id, AttaOrder.class);
    }
}
