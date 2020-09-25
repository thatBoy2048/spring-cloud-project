package com.zjmy.consul_provider.service.impl;

import com.zjmy.commons.domain.AttaOrder;
import com.zjmy.consul_provider.mapper.AttaMapper;
import com.zjmy.consul_provider.service.AttaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        attaOrder.setPort(this.port);
        return attaOrder;
    }

    @Override
    public AttaOrder createAttaOrder(AttaOrder attaOrder) {
        attaMapper.createAttaOrder(attaOrder);
        attaOrder.setPort(this.port);
        return attaOrder;
    }
}
