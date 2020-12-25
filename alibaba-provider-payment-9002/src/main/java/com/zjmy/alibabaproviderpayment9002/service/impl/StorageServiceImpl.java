package com.zjmy.alibabaproviderpayment9002.service.impl;

import com.zjmy.alibabaproviderpayment9002.mapper.StorageMapper;
import com.zjmy.alibabaproviderpayment9002.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhongXiang
 * Date on 2020/12/23  15:40
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    // 扣减库存
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }

}
