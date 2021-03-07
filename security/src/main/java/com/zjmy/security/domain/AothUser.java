package com.zjmy.security.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  11:43
 */
@Getter
@Setter
public class AothUser {


    private Integer id;

    private String username;

    private String password;

}
