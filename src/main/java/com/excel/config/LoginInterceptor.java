package com.excel.config;

import com.excel.domain.User;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean check = false;
        StringBuffer url = request.getRequestURL();
        if(isStatic(url)||url.toString().contains("log")){
            check = true;
        }else{
            Properties props = new Properties();
            props= PropertiesLoaderUtils.loadAllProperties("base.properties");
            String auth= (String) request.getSession().getAttribute((String) props.get("username"));
            if(auth == null){
                String scheme = request.getScheme();
                String serverName = request.getServerName();
                int port = request.getServerPort();
                String context = request.getContextPath();
                String path = scheme+"://"+serverName+":"+port+context+"/";
                String str = "<script language='javascript'>alert('登录状态过期，请重新登陆!');"
                        +"if (window != top){top.location.href = '"+ path +"login.html';}location.href='"+path+"login'"
                        +"</script>";
                response.setContentType("text/html;charset=UTF-8");// 解决中文乱码
                try {
                    PrintWriter writer = response.getWriter();
                    writer.write(str);
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                check = true;
            }
        }
        return  check;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    public boolean isStatic(StringBuffer url) {
        boolean result = false;
        String[] arr = { //定义一个需要放行的数组
                "/login",
                "/css",
                "/images",//图片
                "/js" //js脚本
        };
        for (String a : arr) {
            if (url.indexOf(a) != -1) {
                result = true;
            }
        }
        return result;
    }
}
