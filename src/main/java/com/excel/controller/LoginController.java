package com.excel.controller;


import com.excel.domain.User;
import com.excel.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/landing")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String lanLogin(@RequestParam("UserName")  String username, @RequestParam("Password") String password){


        User user=userMapper.findByNamePassword(username,password);

        System.out.println(username+"11111111"+password);
        if(username.equals("18419701030it")&&password.equals("cy18419701030")){
            System.out.println("123456789");
            return "redirect:1111.html";
        }
        return "用户名错误";
    }


}
