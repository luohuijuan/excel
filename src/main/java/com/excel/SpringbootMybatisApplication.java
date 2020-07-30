package com.excel;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.excel.util.ExcelUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@Bean
    public ObjectMapper jacksonObjectMapperCustomization() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        dateFormat.setTimeZone(timeZone);
        return new Jackson2ObjectMapperBuilder().timeZone(timeZone).dateFormat(dateFormat).build();
    }
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
        converters.add(new MappingJackson2HttpMessageConverter(jacksonObjectMapperCustomization()));
	}
}
