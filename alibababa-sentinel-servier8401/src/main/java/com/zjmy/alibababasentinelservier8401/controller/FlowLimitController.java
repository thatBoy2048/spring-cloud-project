package com.zjmy.alibababasentinelservier8401.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhongXiang
 * Date on 2020/11/26  15:58
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Value("${file.path}")
    private String filePath;

    @SneakyThrows
    @GetMapping("/test1")
    public String test1() {
        //Thread.sleep(500);
        log.info("test1###################" + Thread.currentThread().getName());
        File inputStream = new File(filePath);
        return "访问成功---------------test1"+inputStream.getCanonicalFile().getName() + inputStream.getName();
    }

    @SneakyThrows
    @GetMapping("/test2")
    public String test2() {
        log.info("test2###################" + Thread.currentThread().getName());
        return "访问成功---------------test2";
    }

    @SneakyThrows
    @GetMapping("/testd")
    public String testd() {
        //TimeUnit.SECONDS.sleep(1);
        int age = 10 / 0;
        log.info("testd###################" + Thread.currentThread().getName());
        return "访问成功---------------testd";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "block_info")
    public String testHotKey(@RequestParam(value = "b1", required = false) String b1,
                             @RequestParam(value = "b2", required = false) String b2) {
        //TimeUnit.SECONDS.sleep(1);
        //int age = 10/0;
        log.info("testd###################" + Thread.currentThread().getName());
        return "访问成功---------------testHotKey";
    }

    public String block_info(String b1, String b2, BlockException exception) {

        return "block_info----------------------热点限流";
    }

}