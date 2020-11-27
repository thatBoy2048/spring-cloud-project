package com.zjmy.alibababasentinelservier8401.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/11/26  15:58
 */
@RestController
@Slf4j
public class FlowLimitController
{

    @SneakyThrows
    @GetMapping("test1")
    public String test1(){
        //Thread.sleep(500);
        log.info("test1###################"+Thread.currentThread().getName());
        return "访问成功---------------test1";
    }

    @SneakyThrows
    @GetMapping("test2")
    public String test2(){
        log.info("test2###################"+Thread.currentThread().getName());
        return "访问成功---------------test2";
    }


}
