package com.shiro.springbootshiro.controller;


import com.shiro.springbootshiro.pojo.User;
import io.swagger.annotations.ApiModel;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    /**
     * shiro login
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
//        System.out.println("login");
        //获取当前登陆用户
        Subject subject = SecurityUtils.getSubject();

//        将登陆输入的数据封装到UsernamePasswordToken里面，调用login里面去调用shirorealm的认证方法
//        认证方法会使用这个usernamepasswordtoken获取到username，使用username去查找对应的用户信息
//        把用户信息封装到认证对象里面（AuthenticationInfo），之后比对info以及token的认证标识（密码）
//        如果两个认证不一致就代表登陆密码错误，抛出IncorrectCredentialsException异常

        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            //执行登陆
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            //用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
    @RequestMapping("/user")
    public User getUser(){
        return new User();
    }
}
