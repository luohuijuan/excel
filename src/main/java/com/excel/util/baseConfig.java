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

    public  boolean springUtil(String name ,String password){
        Properties props = new Properties();
        while(true){
            try {
                props= PropertiesLoaderUtils.loadAllProperties("base.properties");
                for(Object key:props.keySet()){
                    if(key.equals(name)&&password.equals(props.get(key))){
                        return true;
                    }else{
                        return false;
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
