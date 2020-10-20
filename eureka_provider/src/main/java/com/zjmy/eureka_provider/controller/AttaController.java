package com.zjmy.eureka_provider.controller;

import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.eureka_provider.service.AttaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:10
 */
@RestController
@Slf4j
public class AttaController {

    @Autowired
    private AttaService attaService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/project/atta/{id}")
    public AttaOrder selectAttaOrderById(@PathVariable Integer id){
        AttaOrder attaOrder = attaService.selectAttaOrderById(id);
        return attaOrder;
    }

    @PostMapping("/project/atta/create")
    public AttaOrder createAttaOrder(@RequestBody AttaOrder attaOrder){
        return attaService.createAttaOrder(attaOrder);
    }

    /**
     * 服务发现
     * @return
     */
    @GetMapping(value = "/project/atta/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances =
                discoveryClient.getInstances("eureka-provider-atta");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }


}
