package com.shiro.springbootshiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("/login");
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/update.html").setViewName("/user/update");
        registry.addViewController("/add.html").setViewName("/user/add");
        registry.addViewController("/unauthorized.html").setViewName("/unauthorized");

    }
}
