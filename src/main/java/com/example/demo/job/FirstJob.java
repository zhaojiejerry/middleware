package com.example.demo.job;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-13:21
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class FirstJob {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void task() {
        kafkaTemplate.send("test","傻子");
        System.out.println("任务1执行....当前时间为" + dateFormat().format(new Date()));
    }

    private SimpleDateFormat dateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat;
    }
}
