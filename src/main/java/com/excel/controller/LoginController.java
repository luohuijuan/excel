package com.excel.controller;


import com.excel.domain.User;
import com.excel.mapper.UserMapper;
import com.excel.util.baseConfig;
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


    @Autowired
    private  baseConfig base;

    @RequestMapping("/login")
    public String lanLogin(@RequestParam("UserName")  String username, @RequestParam("Password") String password){
        boolean boo=base.springUtil(username,password);
        if(boo){
            return "redirect:1111.html";
        }else {
            return "用户名错误";
        }
    }


}
