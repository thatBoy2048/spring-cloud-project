package com.zjmy.alibabaproviderpayment9001.service;

import com.zjmy.commons.domain.AttaOrder;

import java.util.List;

/**
 * @author ZhongXiang
 * Date on 2020/11/23  11:34
 */
public interface PaymentService {
    /**
     * 插入mongo数据
     * @return
     */
    AttaOrder createPaymentMongo(List<AttaOrder> order);

    /**
     * 修改mongo
     * @param order
     * @return
     */
    AttaOrder updatePaymentMongo(AttaOrder order);

    /**
     *  del mongo
     * @param id
     * @return
     */
    String deletePaymentMongo(Integer id);
}
