package com.zjmy.eureka_provider.service;

import com.zjmy.eureka_provider.domain.AttaOrder;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:12
 */
public interface AttaService {

    /**
     * 查询附件订单
     * @param id
     * @return
     */
    AttaOrder selectAttaOrderById(Integer id);
}
