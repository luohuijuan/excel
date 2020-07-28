package com.excel.controller;

import com.excel.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DataController {


    @Autowired
    private DataMapper dataMapper;

    @RequestMapping("/dept")
    public List<Map> queryUserList(){
        List<Map> dept = dataMapper.queryDeptList();
        return dept;
    }
}
