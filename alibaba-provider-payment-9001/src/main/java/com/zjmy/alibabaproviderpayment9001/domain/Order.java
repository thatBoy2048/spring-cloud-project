package com.zjmy.alibabaproviderpayment9001.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author ZhongXiang
 * Date on 2020/12/16  16:20
 */
@Getter
@Setter
@AllArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;
    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;


}
