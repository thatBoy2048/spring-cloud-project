package com.zjmy.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  11:25
 */
@RestController
@RequestMapping("/r")
public class SecurityController {

    @GetMapping("/index/success")
    public String indexSuccess(){
        return "登陆成功！！！！！！！！！";
    }

    @GetMapping("/test")
    public String test(){
        return "访问资源成功！！！！！！！！！";
    }
}
