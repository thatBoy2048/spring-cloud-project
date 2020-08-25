package com.zjmy.eureka_consumer.service.impl;

import com.zjmy.eureka_consumer.constants.EurekaConsumreConstants;
import com.zjmy.eureka_consumer.service.AttaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  13:37
 */
@Service
public class AttaConsumerServiceImpl implements AttaConsumerService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Object selectAttaById(Integer id) {
        Object forObject = restTemplate.getForObject(EurekaConsumreConstants.ATTA_URI+id, Object.class);
        return forObject;
    }
}
