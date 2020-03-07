package com.qzh.epidemic;

import com.qzh.epidemic.entity.*;
import com.qzh.epidemic.service.CrawlerService;
import com.qzh.epidemic.service.TimeLineService;
import com.qzh.epidemic.utils.DateUtil;
import com.qzh.epidemic.utils.StatisticDataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
