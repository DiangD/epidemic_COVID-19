package com.qzh.epidemic.config;

import com.qzh.epidemic.job.CrawlerJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName QuartzCinfigration
 * @Author DiangD
 * @Date 2020/2/27
 * @Version 1.0
 * @Description 爬虫定时任务配置类
 **/
@Configuration
public class QuartzConfiguration {
    @Bean
    @Qualifier("crawlerJobDetail")
    public JobDetail crawlerJobDetail() {
        return JobBuilder.newJob(CrawlerJob.class).withIdentity("crawlerJob").storeDurably().build();
    }


    @Bean
    @Qualifier("crawlerJobTrigger")
    public Trigger crawlerJobTrigger() {
        //配置每1小时执行一个爬虫任务
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(1).repeatForever();
        return TriggerBuilder.newTrigger().forJob(crawlerJobDetail())
                .withIdentity("crawlerJobTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}
