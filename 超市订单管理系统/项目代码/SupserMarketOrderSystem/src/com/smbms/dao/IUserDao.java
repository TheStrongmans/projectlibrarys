package com.smbms.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface IUserDao {

    //查询数据库中是否存在当前用户名和密码，如果存在，则获得该用户的全部个人信息，并封装成Map
    //也就意味登录成功
    @Select("select * from smbms_user where userName=#{userName} and userPassword=#{userPassword}")
    Map<String,Object> login(@Param("userName") String username, @Param("userPassword")String password);
}
