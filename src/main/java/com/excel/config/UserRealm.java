package com.excel.config;

import com.excel.domain.Admin;
import com.excel.mapper.InfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.sampled.Line;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权 doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpInfo = new SimpleAuthorizationInfo();
        //获取当前用户的对象
        Subject subject = SecurityUtils.getSubject();
        Line.Info user = (Line.Info) subject.getPrincipal();//获取用户信息
        // simpInfo.addStringPermission(user.getPerm());//获取数据库权限
        return simpInfo;
    }

    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authenticationToken;
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        String captcha = token.getCaptcha();

        Session session = SecurityUtils.getSubject().getSession();
        String sessionCaptcha = (String) session.getAttribute("captcha");
        session.setAttribute("captcha", "");
        if (null == captcha || !captcha.equalsIgnoreCase(sessionCaptcha) || "".equals(sessionCaptcha)) {
            throw new CaptchaException();
        }

        Admin admin = infoMapper.findByNameAndPassword(username, password);

        if (admin == null) {
            throw new AuthenticationException(username);
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                password,
                getName()
        );
        return authenticationInfo;

    }
}