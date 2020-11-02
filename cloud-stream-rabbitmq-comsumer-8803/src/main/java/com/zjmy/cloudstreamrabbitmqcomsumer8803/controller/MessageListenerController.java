package com.zjmy.cloudstreamrabbitmqcomsumer8803.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author ZhongXiang
 * Date on 2020/10/30  16:18
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class MessageListenerController
{
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message)
    {
        log.info("消费者2号， -----> 接受到的消息： " + message.getPayload()
                + "\t port: " + serverPort);
    }



}
