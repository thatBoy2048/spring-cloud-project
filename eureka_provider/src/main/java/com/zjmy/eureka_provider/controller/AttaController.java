package com.zjmy.eureka_provider.controller;

import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.eureka_provider.service.AttaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:10
 */
@RestController
@RequestMapping("/project/atta")
public class AttaController {

    @Autowired
    private AttaService attaService;

    @GetMapping("/{id}")
    public AttaOrder selectAttaOrderById(@PathVariable Integer id){
        AttaOrder attaOrder = attaService.selectAttaOrderById(id);
        return attaOrder;
    }


}
