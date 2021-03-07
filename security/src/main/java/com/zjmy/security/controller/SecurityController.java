package com.zjmy.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  11:25
 */
@RestController
public class SecurityController {

    @PostMapping("/r/index/success")
    public String indexSuccess(){
        return "登陆成功！！！！！！！！！";
    }

    @GetMapping("/r/test1")
    public String test(){
        return "访问资源成功 1 ！！！！！！！！！";
    }

    @GetMapping("/r/test2")
    public String test2(){
        return "访问资源成功 2 ！！！！！！！！！";
    }
}
