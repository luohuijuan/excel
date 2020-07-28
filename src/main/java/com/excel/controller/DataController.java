package com.excel.controller;

import com.excel.mapper.DataMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DataController {


    @Autowired
    private DataMapper dataMapper;

    @RequestMapping("/dept")
    @ResponseBody
    public List<Map> queryDeptList(){
        List<Map> dept = dataMapper.queryDeptList();
        return dept;
    }

    @RequestMapping("/chain")
    @ResponseBody
    public Object queryChainList(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map> list= dataMapper.queryChainList();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

}
