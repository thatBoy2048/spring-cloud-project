package com.zjmy.alibabaproviderpayment9001.service.impl;

import com.zjmy.alibabaproviderpayment9001.domain.Order;
import com.zjmy.alibabaproviderpayment9001.mapper.OrderMapper;
import com.zjmy.alibabaproviderpayment9001.service.OrderService;
import com.zjmy.alibabaproviderpayment9001.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhongXiang
 * Date on 2020/12/22  17:27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {

        orderMapper.create(order);

        storageService.decrease(order.getProductId(),order.getCount());

        orderMapper.update(order.getUserId(),0);
        int i = 10/0;
    }
}
