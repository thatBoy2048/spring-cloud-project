package com.zjmy.geteway9527.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhongXiang
 * Date on 2020/10/20  18:11
 */
@Configuration
public class GeteWayConfig {

    @Bean
    public RouteLocator MyRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_eiletxie",
                item -> item.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    } @Bean
    public RouteLocator MyRouteLocator1(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_eiletxie1",
                item -> item.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
    @Bean
    public RouteLocator MyRouteLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_eiletxie2",
                item -> item.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }
    @Bean
    public RouteLocator MyRouteLocator3(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_eiletxie3",
                item -> item.path("/mil")
                        .uri("http://news.baidu.com/mil")).build();

        return routes.build();
    }

}
