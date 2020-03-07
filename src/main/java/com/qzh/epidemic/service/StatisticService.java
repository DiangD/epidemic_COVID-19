package com.qzh.epidemic.service;

import com.qzh.epidemic.entity.Statistic;

public interface StatisticService {
    int addStatistic(Statistic statistic);

    Statistic selectStatistic();
}
