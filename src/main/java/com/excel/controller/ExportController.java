package com.excel.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.excel.mapper.DataMapper;
import com.excel.util.ExcelUtil;

@Controller
public class ExportController {
	@Autowired
    private DataMapper dataMapper;

    @RequestMapping("/chainexcel")
    public String exportChain(@RequestParam("target") String target){
    	List<Map<String, Object>> list= dataMapper.queryChainList();
    	Map<String, List<Map<String, Object>>> map = new LinkedHashMap<String, List<Map<String,Object>>>();
    	String filename = (target == null || (target = target.trim()).isEmpty()) ? "门店数据" : target;
    	map.put(filename, list);
    	try {
    		System.out.println(this.getClass().getResource("/").getPath() + "static/download/" + filename + ".xlsx");
			ExcelUtil.writeExcel(map, this.getClass().getResource("/").getPath() + "static/download/" + filename + ".xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	try {
			return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
    }

}
