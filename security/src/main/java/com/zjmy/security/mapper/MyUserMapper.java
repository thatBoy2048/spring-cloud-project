package com.zjmy.security.mapper;

import com.zjmy.security.domain.AothUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhongXiang
 * Date on 2021/2/26  11:39
 */
@Mapper
public interface MyUserMapper  {
    /**
     *
     * @param userName
     * @return
     */
    AothUser selectUserByUserName(@Param("userName") String userName);
}
