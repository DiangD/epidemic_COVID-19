package com.qzh.epidemic.service.impl;

import com.qzh.epidemic.entity.Statistic;
import com.qzh.epidemic.mapper.StatisticMapper;
import com.qzh.epidemic.service.StatisticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName StatisticServiceImpl
 * @Author DiangD
 * @Date 2020/2/25
 * @Version 1.0
 * @Description
 **/
@Service
public class StatisticServiceImpl implements StatisticService {
    @Resource
    private StatisticMapper statisticMapper;

    /**
     * @param statistic statistic
     * @return 成功插入的个数
     */
    @Override
    public int addStatistic(Statistic statistic) {
        return statisticMapper.addStatistic(statistic);
    }

    /**
     * @return 查询最新一条Statistic
     */
    @Override
    public Statistic selectStatistic() {
        return statisticMapper.selectStatistic();
    }
}
