package com.excel.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class baseConfig {

    public  boolean share;

    public  boolean springUtil(String name ,String password){
        Properties props = new Properties();
        while(true){
            try {
                props= PropertiesLoaderUtils.loadAllProperties("base.properties");
                if(props.get("username").equals(name)&&props.get("password").equals(password)){
                    share=true;
                    return true;
                }else{
                    return false;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }





}
