package com.qzh.epidemic.job;

import com.qzh.epidemic.service.CrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName CrawlerJob
 * @Author DiangD
 * @Date 2020/2/27
 * @Version 1.0
 * @Description 爬虫定时任务
 **/
@Slf4j
public class CrawlerJob extends QuartzJobBean {


    @Autowired
    private CrawlerService crawlerService;
    @Override
    protected void executeInternal(JobExecutionContext context) {
        try {
            crawlerService.saveOrUpdateAllInformation();
            log.info("爬虫任务开启");
        } catch (Exception e) {
            log.error("爬虫启动失败!数据无法更新", e);
        }

    }
}
