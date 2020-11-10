package com.graduate.loyee.controller;

import com.graduate.loyee.service.user.UserService;
import com.graduate.loyee.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserService userService;


    @GetMapping("/user/update")
    public String test2Function(){
        return "This is /user/update";
    }

    @GetMapping("/user/add")
    public String testFunction(){
//        Subject subject = SecurityUtils.getSubject();
//        subject.isPermitted("perms[user:add]");
        return "This is /user/add";
    }

    @GetMapping("login")
    public String login(LoginUserVo loginUserVo){
        //获取当前的用户、
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginUserVo.getAccount(),loginUserVo.getPassword());
        //封装用户的登录数据

        try {
            subject.login(token);
            return "登录成功"+token;
        }catch (UnknownAccountException e){
            return "用户名错误";
        }catch (IncorrectCredentialsException e){
            return "密码错误";
        }
    }

    @GetMapping("/unauthor")
    @ResponseBody
    public String unauthor(){
        return "这是未经授权的页面";
    }



}
