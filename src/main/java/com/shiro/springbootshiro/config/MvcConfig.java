package com.shiro.springbootshiro.config;

import com.shiro.springbootshiro.config.properties.SwaggerProperties;
import io.swagger.models.auth.In;
import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.lang.reflect.Field;
import java.util.*;

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
