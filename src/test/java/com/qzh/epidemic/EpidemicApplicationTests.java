package com.qzh.epidemic;

import com.qzh.epidemic.service.CrawlerService;
import com.qzh.epidemic.service.TimeLineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EpidemicApplicationTests {
    @Autowired
    private TimeLineService timeLineService;
    @Autowired
    private CrawlerService crawlerService;

    @Test
    void contextLoads() {
    }

}
