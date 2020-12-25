package com.zjmy.alibabaproviderpayment9002.service;

/**
 * @author ZhongXiang
 * Date on 2020/12/23  15:40
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);

}
