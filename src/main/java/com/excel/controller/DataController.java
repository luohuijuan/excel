package com.excel.controller;

import com.excel.mapper.DataMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/data1")
    @ResponseBody
    public Object data1(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex, pageSize);
        List<Map<String, Object>> list= dataMapper.data1((pageIndex - 1) * pageSize, pageSize);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data2")
    @ResponseBody
    public Object data2(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data2();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data3")
    @ResponseBody
    public Object data3(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data3();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data4")
    @ResponseBody
    public Object data4(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data4();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data5")
    @ResponseBody
    public Object data5(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data5();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data6")
    @ResponseBody
    public Object data6(@RequestParam  Map<String, String> map){
        PageHelper.startPage(Integer.valueOf(map.get("page")), Integer.valueOf(map.get("rows")));
        List<Map<String, Object>> list= dataMapper.data6(map);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data7")
    @ResponseBody
    public Object data7(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data7();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data8")
    @ResponseBody
    public Object data8(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data8();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @RequestMapping("/data9")
    @ResponseBody
    public Object data9(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.data9();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    

    @RequestMapping("/chain")
    @ResponseBody
    public Object queryChainList(@RequestParam("page") int pageIndex, @RequestParam("rows") int pageSize, @RequestParam("sort") String sortList, @RequestParam("order") String orderList){
        PageHelper.startPage(pageIndex,pageSize);
        List<Map<String, Object>> list= dataMapper.queryChainList();
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

}
