package com.zjmy.openFeign.consumer.service;

import com.zjmy.commons.domain.AttaOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZhongXiang
 * Date on 2020/9/29  14:43
 */
@Component
@FeignClient(value = "EUREKA-PROVIDER-ATTA")
public interface OpenFeignOrderService {

    @GetMapping("/project/atta/{id}")
    public AttaOrder selectAttaOrderById(@PathVariable("id") Integer id);
}
