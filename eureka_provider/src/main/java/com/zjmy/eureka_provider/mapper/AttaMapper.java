package com.zjmy.eureka_provider.mapper;

import com.zjmy.eureka_provider.domain.AttaOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:57
 */
@Mapper
public interface AttaMapper {

    /**
     * 查询附件订单
     * @param id
     * @return
     */
    AttaOrder selectAttaOrderById(@Param("id") Integer id);
}
