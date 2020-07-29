package com.excel.util;


import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@Component
public class baseConfig {

    public  boolean springUtil(String name ,String password){
        Properties props = new Properties();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
            try {
                props= PropertiesLoaderUtils.loadAllProperties("base.properties");
                if(props.get("username").equals(name)&&props.get("password").equals(password)){
                    session.setAttribute(name,password);
                    session.setMaxInactiveInterval(6000);
                    String ss= (String) session.getAttribute(name);
                    return true;
                }else{
                    return false;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        return false;
    }





}
