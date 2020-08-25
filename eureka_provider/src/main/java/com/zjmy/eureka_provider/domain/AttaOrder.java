package com.zjmy.eureka_provider.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:35
 */
@Data
public class AttaOrder {

    private Integer id;

    private String  name;

    private String  orderCode;

    private Double amount;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String port;

}
