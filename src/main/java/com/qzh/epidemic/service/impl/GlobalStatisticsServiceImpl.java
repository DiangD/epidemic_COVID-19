package com.qzh.epidemic.service.impl;

import com.qzh.epidemic.entity.GlobalStatistics;
import com.qzh.epidemic.mapper.GlobalStatisticsMapper;
import com.qzh.epidemic.service.GlobalStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName GlobalStatisticsServiceImpl
 * @Author DiangD
 * @Date 2020/4/10
 * @Version 1.0
 * @Description
 **/
@Service
public class GlobalStatisticsServiceImpl implements GlobalStatisticsService {
    @Resource
    private GlobalStatisticsMapper globalStatisticsMapper;
    @Override
    public void addGlobalStatistics(GlobalStatistics globalStatistics) {
        globalStatisticsMapper.insertGlobalStatistics(globalStatistics);
    }

    @Override
    public GlobalStatistics select() {
        return globalStatisticsMapper.selectGlobalStatistics();
    }
}
