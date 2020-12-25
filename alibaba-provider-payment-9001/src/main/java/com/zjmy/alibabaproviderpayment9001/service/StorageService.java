package com.zjmy.alibabaproviderpayment9001.service;

import com.zjmy.commons.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZhongXiang
 * Date on 2020/12/23  9:05
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService{

    @PostMapping(value = "/storage/decrease")
    AjaxResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

