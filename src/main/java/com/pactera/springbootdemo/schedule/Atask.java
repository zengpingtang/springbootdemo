package com.pactera.springbootdemo.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class Atask {

    @Scheduled(cron="0/10 * *  * * ? ")
    public void taskMethod(){

        System.out.println("============="+ new Date().getTime());

    }

}
