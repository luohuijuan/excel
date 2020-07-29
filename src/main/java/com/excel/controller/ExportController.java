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
@RequestMapping("/export")
public class ExportController {
	@Autowired
    private DataMapper dataMapper;

    @RequestMapping("/data1")
    public String data1(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap){
    	System.out.println(target);
    	System.out.println(parameterMap);
        List<Map<String, Object>> list= dataMapper.data1(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	String filename = ((target == null || (target = target.trim()).isEmpty()) ? "data1" : target) + System.currentTimeMillis();
    	dataMap.put(filename, list);
    	try {
			ExcelUtil.writeExcel(dataMap, this.getClass().getResource("/").getPath() + "static/download/" + filename + ".xlsx");
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
    
    @RequestMapping("/data6")
    public String data6(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap){
    	System.out.println(target);
    	System.out.println(parameterMap);
        List<Map<String, Object>> list= dataMapper.data6(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	String filename = ((target == null || (target = target.trim()).isEmpty()) ? "data6" : target) + System.currentTimeMillis();
    	dataMap.put(filename, list);
    	try {
			ExcelUtil.writeExcel(dataMap, this.getClass().getResource("/").getPath() + "static/download/" + filename + ".xlsx");
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
	@RequestMapping("/data9")
    public  String data9(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap){
		List<Map<String, Object>> list=dataMapper.data9(parameterMap);
		Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
		String filename = (target == null || (target = target.trim()).isEmpty()) ? "data6" : target;
		dataMap.put(filename, list);
		try {
			ExcelUtil.writeExcel(dataMap, this.getClass().getResource("/").getPath() + "static/download/" + filename + ".xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	};

}
