package com.zjmy.consul_provider.service;
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
     *
     * @param attaOrder
     * @return
     */
    AttaOrder createAttaOrder(AttaOrder attaOrder);
}
