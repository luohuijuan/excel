package com.excel;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.excel.util.ExcelUtil;

@SpringBootApplication
public class SpringbootMybatisApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
		ExcelUtil.downloadPath = System.getProperty("user.home") + File.separator +"yimeiduoDownloadExcel";
		File downloadRoot = new File(ExcelUtil.downloadPath);
		downloadRoot.deleteOnExit();
		downloadRoot.mkdirs();
		resourceHandlerRegistry.addResourceHandler("/download/**").addResourceLocations(downloadRoot.toURI().toString());
	}
}
