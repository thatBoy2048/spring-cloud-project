package com.zjmy.alibabaproviderpayment9001.mapper;

import com.zjmy.alibabaproviderpayment9001.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhongXiang
 * Date on 2020/12/22  17:28
 */
@Mapper
public interface OrderMapper {

    //新建订单
    void create(Order order);


    /**
     * 修改订单状态，从零改为1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);


}
