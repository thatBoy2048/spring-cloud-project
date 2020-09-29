package com.zjmy.openFeign.consumer.controller;

import com.zjmy.commons.constants.EurekaConsumreConstants;
import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.commons.result.AjaxResult;
import com.zjmy.commons.result.BaseController;
import com.zjmy.openFeign.consumer.service.OpenFeignOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/9/29  14:50
 */
@RestController
@Slf4j
public class OpenFeignOrderController extends BaseController {

    @Autowired
    private OpenFeignOrderService openFeignOrderService;

    @GetMapping("project/openFeign/{id}")
    public AjaxResult selectAttaById(@PathVariable Integer id){
        return toAjaxSuccess(openFeignOrderService.selectAttaOrderById(id));

    }
}
