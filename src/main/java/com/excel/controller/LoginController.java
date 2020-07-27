package com.excel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/landing")
public class LoginController {


    @RequestMapping("/login")
    public String lanLogin(@RequestParam("UserName")  String userName, @RequestParam("Password") String password){
        System.out.println(userName+"11111111"+password);
        if(userName.equals("18419701030it")&&password.equals("cy18419701030")){
            System.out.println("123456789");
            return "redirect:1111.html";
        }
        return "用户名错误";
    }


}
