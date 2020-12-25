package com.zjmy.alibabaproviderpayment9002.controller;

import com.zjmy.alibabaproviderpayment9002.service.StorageService;
import com.zjmy.commons.result.AjaxResult;
import com.zjmy.commons.result.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/12/23  15:42
 */
@RestController
public class StorageController extends BaseController {

    @Autowired
    private StorageService storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public AjaxResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return success("200  扣减库存成功！");
    }
}


