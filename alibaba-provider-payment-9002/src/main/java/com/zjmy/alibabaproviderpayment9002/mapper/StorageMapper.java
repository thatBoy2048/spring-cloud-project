package com.zjmy.alibabaproviderpayment9002.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhongXiang
 * Date on 2020/12/23  15:35
 */
@Mapper
public interface StorageMapper {

    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);


}
