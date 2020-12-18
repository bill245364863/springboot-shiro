package com.shiro.springbootshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //3.shiroFilterFactoryBean

    /**
     * anon:无需认证就可以访问
     * authc:需要认证才能访问
     * user：必须拥有记住我
     * perms：拥有对某个资源的权限访问
     * role：拥有某个角色才可以访问
     *
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //权限控制,没有授权跳转到没有授权页面
        filterChainDefinitionMap.put("/add.html", "perms[user:add]");
        filterChainDefinitionMap.put("/update.html", "perms[user:update]");
        //这里拦截的请求路径，不是文件地址
        //登陆拦截 /update.html 需要登陆认证之后才可以访问
//        filterChainDefinitionMap.put("/update.html", "authc");
//        filterChainDefinitionMap.put("/add.html", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        认证登陆页面自定义
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //跳转未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized.html");

        return shiroFilterFactoryBean;
    }

    //2.DefautWebSecurityManager
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm);
        return defaultWebSecurityManager;
    }

    //1.创建 realm ，需要自定义类\
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    //整合shiroDialect ：用来整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return  new ShiroDialect();
    }
}
