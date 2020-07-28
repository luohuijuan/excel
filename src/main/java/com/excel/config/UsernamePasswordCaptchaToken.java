package com.excel.config;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Copyright: Bizpower多用户商城系统
 * Copyright: www.bizpower.com
 * Copyright: 天津网城商动科技有限责任公司
 *
 * 自定义登录Token
 * 
 * @author dqw
 * Created 2017/4/14 17:57
 */
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public UsernamePasswordCaptchaToken() {
        super();
    }

    public UsernamePasswordCaptchaToken(String username, String password, String captcha) {
        super(username, password);
        this.captcha = captcha;
    }
}
