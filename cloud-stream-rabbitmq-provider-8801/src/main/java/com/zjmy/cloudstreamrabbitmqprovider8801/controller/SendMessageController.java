package com.zjmy.cloudstreamrabbitmqprovider8801.controller;

import com.zjmy.cloudstreamrabbitmqprovider8801.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/10/30  15:49
 */
@RestController
public class SendMessageController
{

    @Autowired
    private SendMessageService sendMessageService;

    @GetMapping("/sendMessage")
    public String sengMessage(){
        return sendMessageService.sendMessage();
    }

}
