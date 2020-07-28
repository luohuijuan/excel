package com.excel.config;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Copyright: Bizpower多用户商城系统
 * Copyright: www.bizpower.com
 * Copyright: 天津网城商动科技有限责任公司
 *
 * 验证码错误自定义异常
 *
 * @author dqw
 * Created 2017/4/14 17:56
 */
public class CaptchaException extends AuthenticationException {
    public CaptchaException() {
        super();
    }

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaException(String message) {
        super(message);
    }

    public CaptchaException(Throwable cause) {
        super(cause);
    }
}
