package com.zjmy.eureka_provider.service;
import com.zjmy.commons.domain.AttaOrder;

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

    /**
     * 创建
     * @param attaOrder
     * @return
     */
    AttaOrder createAttaOrder(AttaOrder attaOrder);
}
