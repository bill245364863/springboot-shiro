package com.shiro.springbootshiro.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SyncService {
    @Async
    public void  Sync(){
        try {
            Thread.sleep(3000);
            System.out.println("正在处理数据。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
