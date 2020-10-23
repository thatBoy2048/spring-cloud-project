package com.zjmy.geteway9527.filter;

import com.zjmy.commons.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author ZhongXiang
 * Date on 2020/10/23  16:45
 */
@Component
@Slf4j
public class GlobalLogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("#########################   GlobalLogFilter  #############################");
        //获取请求中的key
        String first = exchange.getRequest().getQueryParams().getFirst("user");
        //判断是否带有value
        if(StringUtils.isEmpty(first)){
            //返回错误信息
            log.info("当前为非法用户 😭😭😭😭😭😭"+ new Date());
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //正确进入下一个过滤链
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序，数字越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
