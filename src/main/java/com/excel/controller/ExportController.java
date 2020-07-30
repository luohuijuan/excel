package com.excel.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
    public String data1(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
    	target = (target == null || (target = target.trim()).isEmpty()) ? "data1" : target;
    	List<Map<String, Object>> list= dataMapper.data1(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
    }
    @RequestMapping("/data2")
    public String data2(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
    	target = (target == null || (target = target.trim()).isEmpty()) ? "data2" : target;
    	List<Map<String, Object>> list= dataMapper.data2(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
    }
    @RequestMapping("/data3")
    public String data3(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
    	target = (target == null || (target = target.trim()).isEmpty()) ? "data3" : target;
    	List<Map<String, Object>> list= dataMapper.data3(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
    }
    @RequestMapping("/data4")
    public String data4(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
    	target = (target == null || (target = target.trim()).isEmpty()) ? "data4" : target;
    	List<Map<String, Object>> list= dataMapper.data4(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
    }


	@RequestMapping("/data5")
	public String data5(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
		target = (target == null || (target = target.trim()).isEmpty()) ? "data5" : target;
    	List<Map<String, Object>> list= dataMapper.data5(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
	}


    @RequestMapping("/data6")
    public String data6(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap, HttpServletResponse httpServletResponse) throws IOException{
    	target = (target == null || (target = target.trim()).isEmpty()) ? "data6" : target;
    	List<Map<String, Object>> list= dataMapper.data6(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
    }

	@RequestMapping("/data7")
	public String data7(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
		target = (target == null || (target = target.trim()).isEmpty()) ? "data7" : target;
    	List<Map<String, Object>> list= dataMapper.data7(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
	}

	@RequestMapping("/data8")
	public  String data8(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
		target = (target == null || (target = target.trim()).isEmpty()) ? "data8" : target;
    	List<Map<String, Object>> list= dataMapper.data8(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
	};

	@RequestMapping("/data9")
    public  String data9(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
		target = (target == null || (target = target.trim()).isEmpty()) ? "data9" : target;
    	List<Map<String, Object>> list= dataMapper.data9(parameterMap);
    	Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
    	dataMap.put(target, list);
    	String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
	};

	@RequestMapping("/data10")
	public  String data10(@RequestParam("target") String target, @RequestParam  Map<String, String> parameterMap) throws IOException{
		target = (target == null || (target = target.trim()).isEmpty()) ? "data9" : target;
		List<Map<String, Object>> list= dataMapper.data10(parameterMap);
		Map<String, List<Map<String, Object>>> dataMap = new LinkedHashMap<String, List<Map<String,Object>>>();
		dataMap.put(target, list);
		String filename = target + "_" + System.currentTimeMillis();
		ExcelUtil.writeExcel(dataMap, ExcelUtil.downloadPath + File.separator + filename + ".xlsx");
		return "redirect:/download/" + URLEncoder.encode(filename, "UTF-8") + ".xlsx";
	};

}
