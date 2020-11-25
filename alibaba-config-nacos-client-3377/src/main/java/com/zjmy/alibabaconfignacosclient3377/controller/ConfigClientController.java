package com.zjmy.alibabaconfignacosclient3377.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhongXiang
 * Date on 2020/11/3  15:48
 */
@RestController
@RefreshScope
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @Value("${config.log}")
    private String configlog;

    @GetMapping("/config/info")
    public String getConfigInfo()
    {
        return configInfo +"##################"+configlog;

    }

}

