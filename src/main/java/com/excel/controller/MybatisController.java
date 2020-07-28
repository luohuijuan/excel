package com.excel.controller;

import com.excel.domain.User;
import com.excel.mapper.DataMapper;
import com.excel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class MybatisController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/query")
    @ResponseBody
    public List<Map> queryUserList(){
        List<Map> users = userMapper.queryUserList();
        return users;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public  String  test(){
        return "1111.html";
    }
}
