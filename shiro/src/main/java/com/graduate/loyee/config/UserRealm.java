package com.graduate.loyee.config;

import com.graduate.loyee.entity.User;
import com.graduate.loyee.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //用户访问接口的时候会进入到该方法
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();  //拿到user对象
        //currentUser.getPerms是user:add
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

//        String name = "root";
//        String password = "123456";
        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        String name = userToken.getUsername();
        User user = userService.queryByName(name);
        if(null == user){
            return null;
        }

//        密码认证、shiro
        System.out.println("这里是密码正确了");
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");//realName的默认值为realName()
    }
}
