package com.smbms.service;

import java.util.Map;

public interface IUserService {

    //定义方法，接收控制层发送过来的用户名和密码，用于完成登录功能
    Map<String,Object> login(String username, String password);

}
