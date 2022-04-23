package com.smbms.service;

import com.smbms.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service(value = "userService")
public class UserServiceImp implements IUserService{
    //按照MVC三层架构的执行层，业务逻辑层的数据 需要发送给数据访问层dao
    //因此就需要在该类中获得dao层的对象
    @Autowired
    IUserDao dao;

    @Override
    public Map<String, Object> login(String username, String password) {
        System.out.println("业务逻辑层接收到的数据："+username+" " +password);
        return dao.login(username,password);
    }
}
