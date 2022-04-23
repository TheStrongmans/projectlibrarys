package com.smbms.controller;

import com.smbms.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.Map;

@Controller
public class UserController {
    //按照MVC三层架构的运行流程，控制层需要将数据发给业务逻辑层service
    //因此在控制层中需要将业务逻辑层的类的对象创建
    //自动写入，将业务逻辑层的对象注入进来
    @Autowired
    IUserService userService;

    //定义方法，用于跳转回登录页面
    @RequestMapping("/index.do")
    public String index(HttpSession session){
        //当退出网站，回到登录页面，需要将保存在session中的个人信息清除
        session.invalidate();//直接将session干掉

        return "index";
    }

    //定义方法，用于接收浏览器的登录页面发送过来的用户名和密码
    @RequestMapping("/login.do")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        System.out.println(username +" " + password);
        Map<String, Object> userInfo = userService.login(username, password);
        String url;
        if(userInfo!=null) {
            System.out.println(userInfo);
            //将登录成功的用户的个人信息存储在session中
            session.setAttribute("userInfo",userInfo);
            //session的作用域为浏览器
            url = "redirect:home.do";
        }else{
            System.out.println("当前登录的用户名或密码有误");
            url="index";
        }
        return url;
    }

    @RequestMapping("/home.do")
    public String home(HttpSession session){
//        任何用户进入主页面之前，都要验证session对象中是否保存了用户信息
        String url;
        if(session.getAttribute("userInfo")!=null ){
//            System.out.println();
            //合法用户
            url = "home";
        }else{
            //非法用户，不允许进入主页面，进入登录页面
            url = "index";
        }
        return url;
    }
}
