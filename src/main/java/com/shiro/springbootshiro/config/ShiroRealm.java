package com.shiro.springbootshiro.config;

import com.shiro.springbootshiro.mapper.UserMapper;
import com.shiro.springbootshiro.pojo.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    public UserMapper userMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("授权=》doGetAuthorizationInfo");
        //获取当前登陆对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//当前用户对象

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取用户的权限
        authorizationInfo.addStringPermission(currentUser.getPerms());
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("认证=》doGetAuthenticationInfo");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        User user = userMapper.queryUserByName(usernamePasswordToken.getUsername());
        if(user == null){
            return null;//用户名不存在，自动抛异常UnknownAccountException

        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
