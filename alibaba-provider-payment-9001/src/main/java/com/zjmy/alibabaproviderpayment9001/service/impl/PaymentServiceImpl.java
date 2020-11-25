package com.zjmy.alibabaproviderpayment9001.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.zjmy.alibabaproviderpayment9001.service.PaymentService;
import com.zjmy.commons.domain.AttaOrder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhongXiang
 * Date on 2020/11/23  11:34
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

   @Autowired
   private MongoTemplate mongoTemplate;

    @SneakyThrows
    @Override
    public AttaOrder createPaymentMongo(List<AttaOrder> order) {
        //插入数据
        mongoTemplate.insertAll(order);
        //Thread.sleep(5000);
        //设置插叙条件
        Query query = new Query(Criteria.where("_id").is(order.get(0).getId()));
        //查询数据
        AttaOrder attaOrder = mongoTemplate.findOne(query, AttaOrder.class);
        return attaOrder;
    }

    @Override
    public AttaOrder updatePaymentMongo(AttaOrder order) {
        //多条件修改
        Query query = new Query(new Criteria().and("_id").is(order.getId()).and("createBy").is(order.getCreateBy()));
        //单个条件
        //Query query = new Query(Criteria.where("_id").is(order.getId()));
        Update update = new Update().set("name",order.getName()).set("orderCode",order.getOrderCode());
        mongoTemplate.updateFirst(query,update,AttaOrder.class);
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(order.getId())),AttaOrder.class);
    }

    @Override
    public String deletePaymentMongo(Integer id) {
        DeleteResult id1 = mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), AttaOrder.class);
        log.info("##############################"+id1.toString());
        return id1.toString();
    }


}
