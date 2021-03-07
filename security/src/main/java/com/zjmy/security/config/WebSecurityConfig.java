package com.zjmy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  9:56
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法授权
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  密码编辑器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //使用明文的方式，被废弃,过度
        //return NoOpPasswordEncoder.getInstance();
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()// 关闭csrf防护
                .authorizeRequests()// 定义路径认证
//                .antMatchers("/r/r1").hasAuthority("p2")
//                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                // .antMatchers("/r/**","/user/test").permitAll() //这些路径可以直接访问，不需要认证
                .anyRequest().permitAll()//除了/r/**，其它的请求可以访问
                .and()
                .formLogin()//自定义 允许表单登录
                .loginPage("/login-view")//跳转登录页面
                .loginProcessingUrl("/login")
                .successForwardUrl("/r/index/success")//自定义登录成功的页面地址
        .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login-view?logout");


    }

}
