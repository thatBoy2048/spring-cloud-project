package com.zjmy.cloudstreamrabbitmqprovider8801.service.impl;

import cn.hutool.core.lang.UUID;
import com.zjmy.cloudstreamrabbitmqprovider8801.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author ZhongXiang
 * Date on 2020/10/30  15:53
 */
@EnableBinding(Source.class)
@Slf4j
public class SendMessageServiceImpl implements SendMessageService
{
    @Autowired
    private MessageChannel output;


    @Override
    public String sendMessage() {
        String orderCode = UUID.fastUUID().toString();
        output.send(MessageBuilder.withPayload(orderCode).build());
        log.info("消息发送成功："+ orderCode);
        return orderCode;
    }
}
