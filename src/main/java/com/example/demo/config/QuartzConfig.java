package com.example.demo.config;

import com.example.demo.job.FirstJob;
import com.example.demo.job.SecondJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-13:19
 */
@Configuration
public class QuartzConfig {

    //配置定时任务1
    @Bean(name = "firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobDetail(FirstJob firstJob){
            MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
            //并发执行
            jobDetail.setConcurrent(true);
            //为需要执行的实体类对应的对象
            jobDetail.setTargetObject(firstJob);
            //需要执行的方法
            jobDetail.setTargetMethod("task");
            return jobDetail;
    }

    //配置触发器1
    @Bean(name = "firstTrigger")
    public SimpleTriggerFactoryBean firstTrigger(JobDetail firstJobDetail){
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();

        trigger.setJobDetail(firstJobDetail);
        // 设置任务启动延迟
        trigger.setStartDelay(0);
        // 每10秒执行一次
        trigger.setRepeatInterval(10000);
        return trigger;
    }

    // 配置定时任务2
    @Bean(name = "secondJobDetail")
    public MethodInvokingJobDetailFactoryBean secondJobDetail(SecondJob secondJob) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行,假如设置为10秒一次，如果上一次因为到了时间没有执行那么当前这个任务会并发执行，
        // 如果为false的话就会等上一次执行完才执行
        jobDetail.setConcurrent(true);
        // 为需要执行的实体类对应的对象
        jobDetail.setTargetObject(secondJob);
        // 需要执行的方法
        jobDetail.setTargetMethod("task");
        return jobDetail;
    }

    // 配置触发器2
    @Bean(name = "secondTrigger")
    public CronTriggerFactoryBean secondTrigger(JobDetail secondJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(secondJobDetail);
        // cron表达式，每过10秒执行一次
        trigger.setCronExpression("0/10 * * * * ?");
        return trigger;
    }

    // 配置Scheduler
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger, Trigger secondTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 延时启动，应用启动5秒后
        bean.setStartupDelay(5);
        // 注册触发器
        bean.setTriggers(firstTrigger, secondTrigger);
        return bean;
    }

}
