package com.zjmy.security.service;


import com.zjmy.security.domain.AothUser;
import com.zjmy.security.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  11:26
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AothUser aothUser = myUserMapper.selectUserByUserName(userName);
        if(aothUser == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        UserDetails userDetails = User.withUsername(aothUser.getUsername()).password(aothUser.getPassword()).authorities("/r1/r").build();

        return userDetails;
    }

}
