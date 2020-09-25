package com.zjmy.consul_consumer.controller;

import com.zjmy.commons.constants.EurekaConsumreConstants;
import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.commons.result.AjaxResult;
import com.zjmy.commons.result.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  13:36
 */
@RestController
public class AttaConsumerController extends BaseController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("project/consul/{id}")
    public AjaxResult selectAttaById(@PathVariable Integer id){
        AttaOrder order = restTemplate.
                getForObject(EurekaConsumreConstants.CONSUL_URI +"/project/atta/"+ id, AttaOrder.class);
        return toAjaxSuccess(order);

    }
    @GetMapping("project/consul/create")
    public AjaxResult createAttaOrder(AttaOrder attaOrder){
        AttaOrder order = restTemplate.
                postForObject(EurekaConsumreConstants.ATTA_URI + "/project/atta/create",attaOrder, AttaOrder.class);
        return toAjaxSuccess(order);

    }

}
