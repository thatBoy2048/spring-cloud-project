package com.zjmy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  9:47
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("redirect:/login-view");
//        registry.addViewController("/login-view").setViewName("login");
//
//    }
//
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login-view");
        registry.addViewController("/login-view").setViewName("login");

    }

}
