package com.zjmy.commons.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

/**
 * @author ZhongXiang
 * Date on 2020/8/24  10:35
 */
@Getter
@Setter
@Document(collection ="attaOrder")//指定要对应的文档名(表名）
public class AttaOrder {
    /**
     * 自定义mongo主键 加此注解可自定义主键类型以及自定义自增规则
     * 若不加 插入数据数会默认生成 ObjectId 类型的_id 字段
     * org.springframework.data.annotation.Id 包下
     * mongo库主键字段还是为_id 。不必细究(本文实体类中为id）
     */
    @Id
    private Integer id;

    private String  name;

    private String  orderCode;

    private Double amount;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String port;

}
