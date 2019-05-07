package com.opensams.controller;

import com.opensams.model.vo.response.BasicResponse;
import com.opensams.model.vo.response.HttpCodeEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin Leung
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BasicResponse login(String loginName, String loginPwd) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPwd);
        token.setRememberMe(true);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            BasicResponse response = new BasicResponse();
            response.setCode(HttpCodeEnum.ERROR.getStatusCode());
            response.setMessgae("登录失败");
            return response;
        }
        BasicResponse response = new BasicResponse();
        response.setCode(HttpCodeEnum.SUCCESS.getStatusCode());
        response.setMessgae("登录成功");
        return response;
    }

}
