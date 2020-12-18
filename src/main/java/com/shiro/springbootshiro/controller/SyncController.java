package com.shiro.springbootshiro.controller;

import com.shiro.springbootshiro.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试异步任务
 */
@Controller
public class SyncController {
    @Autowired
    SyncService syncService;

    @RequestMapping("/sync")
    @ResponseBody
    public String sync(){
        syncService.Sync();
        return "sync";
    }
}
