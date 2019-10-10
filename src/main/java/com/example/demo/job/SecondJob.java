package com.example.demo.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-13:31
 */

@Component
@EnableScheduling
public class SecondJob {
    public void task() {
        System.out.println("任务2执行....当前时间为" + dateFormat().format(new Date()));
    }

    private SimpleDateFormat dateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat;
    }
}
