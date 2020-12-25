package com.zjmy.alibabaproviderpayment9002.domain;

import lombok.Data;

/**
 * @author ZhongXiang
 * Date on 2020/12/23  15:34
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

