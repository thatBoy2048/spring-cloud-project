package com.zjmy.eureka_provider.service.impl;

import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.commons.utils.StringUtils;
import com.zjmy.eureka_provider.mapper.AttaMapper;
import com.zjmy.eureka_provider.service.AttaService;
import org.apache.tomcat.jni.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:13
 */
@Service
@Transactional
public class AttaServiceImpl implements AttaService {

    @Autowired
    private AttaMapper attaMapper;

    @Value("${server.port}")
    private String port;


    @Override
    public AttaOrder selectAttaOrderById(Integer id) {
        AttaOrder attaOrder = attaMapper.selectAttaOrderById(id);
        if(StringUtils.isNull(attaOrder)){
            return null;
        }
        attaOrder.setPort(this.port);

        //openFeign默认调用提供者时间1秒，超过1秒会报超时异常
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return attaOrder;
    }

    @Override
    public AttaOrder createAttaOrder(AttaOrder attaOrder) {
        attaMapper.createAttaOrder(attaOrder);
        attaOrder.setPort(this.port);
        return attaOrder;
    }
}
