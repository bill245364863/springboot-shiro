package com.shiro.springbootshiro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "swagger 测试")
@Controller
public class SwaggerController {
    @ApiOperation("get方法")
    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "HELLO,SWAGGER";
    }
    @ApiOperation("post方法")
    @PostMapping("/psot")
    @ResponseBody
    public String psot(){
        return "HELLO,SWAGGER";
    }
}
